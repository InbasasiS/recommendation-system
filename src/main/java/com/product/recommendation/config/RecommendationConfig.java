package com.product.recommendation.config;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.product.recommendation.model.Product;
import com.product.recommendation.model.Theme;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class RecommendationConfig {

    @Bean
    public List<Theme> themes() throws CsvValidationException {
        List<Theme> themes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/static/themes.csv"))) {
            reader.readNext();
            String[] data;
            while ((data = reader.readNext()) != null) {
                themes.add(Theme.builder()
                        .id(Integer.parseInt(data[0]))
                        .name(data[1])
                        .TotalProducts(Integer.parseInt(data[2]))
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return themes;
    }

    @Bean
    @DependsOn("themes")
    public List<Product> products(List<Theme> themes) throws CsvValidationException {
        List<Product> products = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/static/products.csv"))) {
            reader.readNext();
            String[] data;
            while ((data = reader.readNext()) != null) {
                products.add(Product.builder()
                        .id(Integer.parseInt(data[0]))
                        .name(data[1])
                        .price(Float.valueOf(data[2]))
                        .theme(findTheme(themes, Integer.parseInt(data[3])))
                        .weigtage(Float.valueOf(data[4]))
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return products;
    }

    public Theme findTheme(List<Theme> themes, Integer themeId) {
        for (Theme theme : themes) {
            if (theme.getId().equals(themeId)) {
                return theme;
            }
        }
        return null;
    }
}
