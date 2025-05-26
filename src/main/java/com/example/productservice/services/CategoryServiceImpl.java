package com.example.productservice.services;

import com.example.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
