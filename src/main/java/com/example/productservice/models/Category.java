package com.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "categories")
public class Category extends BaseModel{
    @Column(unique = true, nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Product> products;

    // fetch type of products(list) is LAZY, because if category object in Product class and products(list) both have EAGER fetch then
    // hibernate will get category from Product table, as category has EAGER fetch type all attributes of category will get
    // fetched including products(list) now product also has EAGER fetch type so all the attributes of product class will get
    // fetched and loop continues till infinity
    // to make sure this does not happens products(list) has LAZY fetch type
}
