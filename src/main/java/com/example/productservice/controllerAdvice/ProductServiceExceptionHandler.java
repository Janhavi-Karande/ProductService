package com.example.productservice.controllerAdvice;

import com.example.productservice.dtos.CategoryNotFoundExceptionDto;
import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.dtos.ProductNotFoundExceptionDto;
import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<CategoryNotFoundExceptionDto> handleCategoryNotFoundException(CategoryNotFoundException e) {
        CategoryNotFoundExceptionDto exceptionDto = new CategoryNotFoundExceptionDto();

        exceptionDto.setMessage("Category not found!.");
        exceptionDto.setResolutionDetails("Please provide a valid category name.");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {

        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();

        exceptionDto.setMessage("Product not found");
        exceptionDto.setProductId(e.getProductId());
        exceptionDto.setResolutionDetails("Product with id " +e.getProductId()+ " does not exist.");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e) {

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong.");
        exceptionDto.setResolutionDetails("Reload the page.");
        e.printStackTrace();

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
