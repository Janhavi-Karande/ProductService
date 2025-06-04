package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockitoBean
    private ProductService productService;
    @Autowired
    private ProductController productController;

    @Test
    void getAllProducts() {
    }

    @Test
    public void testGetSingleProductPositiveCase() throws ProductNotFoundException {
        //arrange
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        expectedProduct.setProductName("Study table");
        expectedProduct.setPrice(1345.0);

        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);

        // act
        Product actualProduct = productService.getSingleProduct(productId);

        //assert
        assertEquals(expectedProduct, actualProduct);
    }

    //negative case
    @Test
    void testGetSingleProductInvalidProductId() throws ProductNotFoundException {

        when(productService.getSingleProduct(-1L))
                .thenThrow(new ProductNotFoundException("Please enter correct product Id."));

        assertThrows(ProductNotFoundException.class,
                () -> productService.getSingleProduct(-1L));

    }
}