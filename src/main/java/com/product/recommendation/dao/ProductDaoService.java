package com.product.recommendation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.recommendation.model.Product;

@Service
public class ProductDaoService {

    @Autowired
    private List<Product> products;

    // NOTE:
    // The dummy data is used from the CSV file
    // Incase of relational database being used, Below is the query for retrieval
    // SELECT * FROM products WHERE theme=themeId ORDER BY weightage DESC LIMIT count
    // The themeID,weightage has to be indexed for better performance
    public List<Product> fetchProductsByIdsAndCount(Integer themeId, Integer count) {
        List<Product> productsRemmended = new ArrayList<>();

        for (Product product: products) {
            if (product.getTheme().getId().equals(themeId)) {
                productsRemmended.add(product);
            }

            if (productsRemmended.size() >= count) {
                return productsRemmended;
            }
        }
        return productsRemmended;
    }

}
