package com.product.recommendation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Theme {

    private Integer id;

    private String name;

    private Integer TotalProducts;
}
