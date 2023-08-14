package com.universal.product.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String categoryName;
    private SubcategoryDto subcategory;
}

