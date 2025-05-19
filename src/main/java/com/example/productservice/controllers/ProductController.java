package com.example.productservice.controllers;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private RestTemplate restTemplate;
    private ProductService productService;

    public ProductController(@Qualifier("productServiceImpl") ProductService productService,
                             RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.productService = productService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {


       //       Product product = null;
//
//        try{
//            product = productService.getSingleProduct(productId);
//            productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        catch (ProductNotFoundException e){
//            e.printStackTrace();
//            productResponseEntity = new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
//        }
//        catch (RuntimeException e){
//            e.printStackTrace();
//            productResponseEntity = new ResponseEntity<>(product, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        // the exception occurred here will be handled by controller advice(global exception handler
        ResponseEntity<Product> productResponseEntity = new ResponseEntity<>(productService.getSingleProduct(productId),
                HttpStatus.OK);

        return productResponseEntity;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

    // this method will get more priority than the exception handler in the controller advice
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException() {
//
//        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();
//        exceptionDto.setMessage("Product not found");
//        exceptionDto.setResolutionDetails("Please enter a valid product id.");
//
//        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//    }
}
