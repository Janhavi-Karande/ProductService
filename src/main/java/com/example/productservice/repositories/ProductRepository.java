package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    Product save(Product product);

    @Override
    void deleteById(Long id);

    //@Query("SELECT p FROM Product p WHERE p.id = 1 ")
    //Optional<Product> findProductById(@Param("id") Long id);

    // select * from products where lower(name) like "%IPhone";
    // get all products whose name contains IPhone or iphone
    //List<Product> findByProductNameContainsIgnoreCase(String name);

    // select * from products where price >= 10000 and price <= 200000
    //get all products whose price range is lower to higher
    //List<Product> findByPriceBetween(Double lower, Double higher);

    // select * from products where category_id = category.id;
    // get all products with category id
    //List<Product> findByCategory(Category category);


}
