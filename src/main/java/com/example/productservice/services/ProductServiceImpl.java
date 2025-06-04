package com.example.productservice.services;

import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productServiceImpl")
// Self Product Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        Optional<Product> optionalProduct = productRepository.findById(productId);
//
//        if (optionalProduct.isEmpty()) {
//            throw new ProductNotFoundException(productId, "Product with id " +productId+ " not found");
//        }
//
//        return optionalProduct.get();

       return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " +productId+ " not found"));
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {
//        Category category = product.getCategory();
//
//        if(category == null) {
//            throw new CategoryNotFoundException("Please provide category of the product.");
//        }
//
//        Optional<Category> optionalCategory = categoryRepository.findByCategoryName(category.getCategoryName());
//
//        if(optionalCategory.isEmpty()) {
//            // create new category
//            category = categoryRepository.save(category);
//        }
//        else{
//            category = optionalCategory.get();
//        }
//
//        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product){

        productRepository.deleteById(product.getId());
    }
}
