package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundExceptionDto {
    private String categoryName;
    private String message;
    private String resolutionDetails;

}
