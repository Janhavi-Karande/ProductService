package com.example.productservice.services;

import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    void deleteProduct(Product product);
}
