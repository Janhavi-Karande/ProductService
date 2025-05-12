package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product deleteProduct(Product product);
}
