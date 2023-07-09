package com.product.recommendation.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.recommendation.dao.ProductDaoService;
import com.product.recommendation.dao.ThemeDaoService;
import com.product.recommendation.model.Product;
import com.product.recommendation.model.Theme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RecommendationServiceTest {

    @Mock
    private ThemeDaoService themeDaoService;

    @Mock
    private ProductDaoService productDtoService;

    private RecommendationService recommendationService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        recommendationService = new RecommendationService();
        recommendationService.themeDaoService = themeDaoService;
        recommendationService.productDtoService = productDtoService;
    }

    @Test
    void recommendProductsTest() {
        Integer userId = 100;
        List<Integer> themeIds = Arrays.asList(1001, 2001, 3001);
        Integer noOfProducts = 20;

        List<Theme> userThemes = Arrays.asList(
                Theme.builder().id(1001).name("Theme_A").TotalProducts(20).build(),
                Theme.builder().id(2001).name("Theme_B").TotalProducts(5).build());
        List<Theme> randomThemes = Arrays.asList(
                Theme.builder().id(3001).name("Theme_C").TotalProducts(20).build());
        List<Product> productsA = Arrays.asList(
                Product.builder()
                        .id(101)
                        .name("Product_A_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(102)
                        .name("Product_B_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(103)
                        .name("Product_C_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(104)
                        .name("Product_D_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(105)
                        .name("Product_E_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(106)
                        .name("Product_F_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(107)
                        .name("Product_G_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(108)
                        .name("Product_G_Theme_A")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build());

        List<Product> productsB = Arrays.asList(
                Product.builder()
                        .id(201)
                        .name("Product_A_Theme_B")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(202)
                        .name("Product_B_Theme_B")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(203)
                        .name("Product_C_Theme_B")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(204)
                        .name("Product_D_Theme_B")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(205)
                        .name("Product_E_Theme_B")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build());

        List<Product> productsC = Arrays.asList(
                Product.builder()
                        .id(301)
                        .name("Product_A_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(302)
                        .name("Product_B_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(303)
                        .name("Product_C_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(304)
                        .name("Product_D_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(305)
                        .name("Product_E_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(306)
                        .name("Product_A_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(307)
                        .name("Product_B_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(308)
                        .name("Product_C_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(309)
                        .name("Product_D_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build(),
                Product.builder()
                        .id(310)
                        .name("Product_E_Theme_C")
                        .price(300F)
                        .theme(userThemes.get(0))
                        .weigtage(0.5F)
                        .build());

        when(themeDaoService.fetchThemeByIds(anyList())).thenReturn(new ArrayList<>(userThemes));
        when(themeDaoService.collectRandomThemes(anyList(), anyInt())).thenReturn(new ArrayList<>(randomThemes));

        when(productDtoService.fetchProductsByIdsAndCount(1001, 11)).thenReturn(productsA);
        when(productDtoService.fetchProductsByIdsAndCount(2001, 5)).thenReturn(productsB);
        when(productDtoService.fetchProductsByIdsAndCount(3001, 4)).thenReturn(productsC);
        recommendationService.recommendProducts(userId, themeIds, noOfProducts);

        // This testcase validates the fetchProductsByIdsAndCount method is called with the correct args
        verify(productDtoService).fetchProductsByIdsAndCount(1001, 11);
        verify(productDtoService).fetchProductsByIdsAndCount(2001, 5);
        verify(productDtoService).fetchProductsByIdsAndCount(3001, 4);
    }
}
