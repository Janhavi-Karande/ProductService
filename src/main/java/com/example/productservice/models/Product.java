package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "products")
public class Product extends BaseModel {
    private String productName;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
