package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    private String productName;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
