package com.example.productservice.controllers;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {


        ResponseEntity<Product> productResponseEntity;
        Product product = null;

        try{
            product = productService.getSingleProduct(productId);
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (ProductNotFoundException e){
            e.printStackTrace();
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // the exception occurred here will be handled by controller advice(global exception handler
//        ResponseEntity<Product> productResponseEntity = new ResponseEntity<>(productService.getSingleProduct(productId),
//                HttpStatus.OK);

        return productResponseEntity;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return null;
    }

    // this method will get more priority than the exception handler in the controller advice
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException() {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong in controller.");

        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
