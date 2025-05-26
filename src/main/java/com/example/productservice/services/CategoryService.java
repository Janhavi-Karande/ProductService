package com.example.productservice.services;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    void deleteCategory(Long categoryId);
}
