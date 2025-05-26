package com.example.productservice.controllers;

import com.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
