package com.product.recommendation.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Integer id;

    private String name;

    private Float price;

    private Theme theme;

    private Float weigtage;
}
