package com.product.recommendation.service;

import com.product.recommendation.dao.ProductDaoService;
import com.product.recommendation.dao.ThemeDaoService;
import com.product.recommendation.model.Product;
import com.product.recommendation.model.Theme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecommendationService {

    @Autowired
    ThemeDaoService themeDaoService;

    @Autowired
    ProductDaoService productDtoService;

    private final Integer RECOMMENDATION_THEME_LIMIT = 3;
    private final Integer MAX_RECOMMENDATION_PRODUCT_LIMIT = 20;

    private final Integer USER_THEME_WEIGTAGE = 2;
    private final Integer RANDOM_THEME_WEIGTAGE = 1;

    // The User details will be present in the frontend application
    // Therefore the userId & the interested themes will be passed from the application.
    public List<Product> recommendProducts(Integer userId, List<Integer> themeIds, Integer noOfProducts) {

        log.info("Preparing recommendations for user id -> {}", userId);

        List<Theme> userThemes = themeDaoService.fetchThemeByIds(themeIds);
        List<Theme> randomThemes = findRandomThemes(themeIds, userThemes.size());

        noOfProducts = vaidateAndGetProductCount(noOfProducts);

        if (isThemesEmpty(randomThemes, userThemes)) {
            log.warn("Skip, due to empty themes");
            return null;
        }

        List<Integer> userAndRandomProductCount = getUserAndRandomProductCount(noOfProducts, userThemes, randomThemes);
        Integer totalNoOfUserProducts = userAndRandomProductCount.get(0);
        Integer totalNoOfRandomProducts = userAndRandomProductCount.get(1);

        HashMap<Integer, Integer> noOfthemeProducts = new HashMap<>(RECOMMENDATION_THEME_LIMIT);
        calculateNoOfProductsPerTheme(noOfthemeProducts, userThemes, totalNoOfUserProducts);
        totalNoOfRandomProducts += getRemainingUserProductCount(
                totalNoOfUserProducts, noOfthemeProducts); // Adding the remaining capacity left in user products
        calculateNoOfProductsPerTheme(noOfthemeProducts, randomThemes, totalNoOfRandomProducts);

        log.info("Number of products per theme, {}", noOfthemeProducts);
        return retrieveProducts(noOfthemeProducts);
    }

    private List<Product> retrieveProducts(HashMap<Integer, Integer> noOfthemeProducts) {
        // Fetch the products for each theme by weightage & limit by count
        // This can be computed concurrently to reduce the overall time

        List<Product> productRecommendations = new ArrayList<>();
        for (Map.Entry<Integer, Integer> themeProductCount : noOfthemeProducts.entrySet()) {
            productRecommendations.addAll(productDtoService.fetchProductsByIdsAndCount(
                    themeProductCount.getKey(), themeProductCount.getValue()));
        }
        return productRecommendations;
    }

    private Integer getRemainingUserProductCount(
            Integer totalNoOfUserProducts, HashMap<Integer, Integer> noOfthemeProducts) {

        Integer utilisedUserProductCount = 0;
        for (Map.Entry<Integer, Integer> themeProductCount : noOfthemeProducts.entrySet()) {
            utilisedUserProductCount += themeProductCount.getValue();
        }
        return totalNoOfUserProducts - utilisedUserProductCount;
    }

    private void calculateNoOfProductsPerTheme(
            HashMap<Integer, Integer> noOfthemeProducts, List<Theme> themes, Integer totalNoOfThemeProducts) {
        Integer noOfProductsPerTheme = totalNoOfThemeProducts / themes.size();

        while (true) {
            if (noOfProductsPerTheme == 0 || totalNoOfThemeProducts <= 0 || themes.isEmpty()) {
                break;
            }

            for (int i = 0; i < themes.size(); i++) {
                Theme theme = themes.get(i);
                if (theme.getTotalProducts() < noOfProductsPerTheme) {
                    noOfthemeProducts.put(theme.getId(), theme.getTotalProducts());
                    totalNoOfThemeProducts -= theme.getTotalProducts();

                    // Remove if the theme is exhausted
                    themes.remove(i);
                } else {
                    Integer cumulativeProductCount = (noOfthemeProducts.get(theme.getId()) == null)
                            ? noOfProductsPerTheme
                            : (noOfthemeProducts.get(theme.getId()) + noOfProductsPerTheme);
                    noOfthemeProducts.put(theme.getId(), cumulativeProductCount);
                    totalNoOfThemeProducts -= noOfProductsPerTheme;
                }
            }

            if (totalNoOfThemeProducts == 1 && themes.size() > 0) {
                // Incase of one products left, Add it to the first theme
                Theme firstTheme = themes.get(0);
                noOfthemeProducts.put(
                        firstTheme.getId(), noOfthemeProducts.get(firstTheme.getId()) + noOfProductsPerTheme);
                noOfProductsPerTheme = 0;

            } else if (themes.size() > 0) {
                noOfProductsPerTheme = totalNoOfThemeProducts / themes.size();
            }
        }
    }

    private List<Integer> getUserAndRandomProductCount(
            Integer noOfProducts, List<Theme> userThemes, List<Theme> randomThemes) {
        Integer noOfUserProducts = 0;
        Integer noOfRandomProducts = 0;

        if (randomThemes.isEmpty()) {
            noOfUserProducts = noOfProducts;
        } else if (userThemes.isEmpty()) {
            noOfRandomProducts = noOfProducts;
        } else {
            Double totalWeightage =
                    (double) USER_THEME_WEIGTAGE * userThemes.size() + RANDOM_THEME_WEIGTAGE * randomThemes.size();
            noOfUserProducts = (int)
                    Math.round(((double) ((USER_THEME_WEIGTAGE * userThemes.size()) / totalWeightage)) * noOfProducts);
            noOfRandomProducts = (int) Math.round(
                    ((double) ((RANDOM_THEME_WEIGTAGE * randomThemes.size()) / totalWeightage)) * noOfProducts);
        }
        return Arrays.asList(noOfUserProducts, noOfRandomProducts);
    }

    private Integer vaidateAndGetProductCount(Integer noOfProducts) {
        if (noOfProducts == null || noOfProducts < 1 || noOfProducts > MAX_RECOMMENDATION_PRODUCT_LIMIT) {
            noOfProducts = MAX_RECOMMENDATION_PRODUCT_LIMIT;
        }
        return noOfProducts;
    }

    private List<Theme> findRandomThemes(List<Integer> themeIds, Integer sizeOfUserThemes) {
        List<Theme> randomThemes = new ArrayList<>();

        if (sizeOfUserThemes < RECOMMENDATION_THEME_LIMIT) {
            // Generating random themes
            Integer sizeOfRandomThemes = RECOMMENDATION_THEME_LIMIT - sizeOfUserThemes;
            randomThemes = themeDaoService.collectRandomThemes(themeIds, sizeOfRandomThemes);
        }
        return randomThemes;
    }

    private boolean isThemesEmpty(List<Theme> randomThemes, List<Theme> userThemes) {
        return userThemes.isEmpty() && randomThemes.isEmpty();
    }
}
