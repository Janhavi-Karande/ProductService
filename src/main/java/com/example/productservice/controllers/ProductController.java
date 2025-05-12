package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {



    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {

        return null;
    }

}
