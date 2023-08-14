package com.universal.product.dto;

import lombok.Data;

@Data
public class SubcategoryDto {
    private Long id;
    private String subcategoryName;
    private Long categoryId;
}
