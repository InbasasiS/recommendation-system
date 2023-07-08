package com.product.recommendation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.recommendation.model.FilterOptions;
import com.product.recommendation.model.Product;
import com.product.recommendation.service.RecommendationService;

import lombok.NonNull;

@RestController
@RequestMapping("/api/v1/products")
public class RecommendationController {

    @Autowired
    RecommendationService recommdationService;

    // Used POST since it is a complex recommendation system requiring multiple filter options
    @PostMapping("")
    public List<Product> getRecommendations(@NonNull @RequestParam String user,
     @NonNull @RequestParam String count,
     @RequestBody FilterOptions filterOptions) {

        return recommdationService.recommendProducts(Integer.parseInt(user), filterOptions.getThemes(), Integer.parseInt(count));
    }
}
