package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMockMCVTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;
    @MockitoBean
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProductsApi() throws Exception {

        //arrange
        Product product1 = new Product();
        product1.setProductName("Product 1");
        product1.setPrice(3245.0);
        product1.setId(23L);

        Product product2 = new Product();
        product2.setProductName("Product 1");
        product2.setPrice(3245.0);
        product2.setId(2L);

        List<Product> products = Arrays.asList(product1, product2);

        //act
        when(productService.getAllProducts()).thenReturn(products);

        String expectedJson = objectMapper.writeValueAsString(products);

        //assert
        mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/products/"
                )
        )       .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }
}
