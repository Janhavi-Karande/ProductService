package com.example.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "categories")
public class Category extends BaseModel{
    //@Column(unique = true, nullable = false)
    private String categoryName;
}
