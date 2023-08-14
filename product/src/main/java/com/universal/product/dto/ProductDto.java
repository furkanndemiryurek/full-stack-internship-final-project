package com.universal.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String productName;
    private String description;
    private double unitPrice;
    private int unitsInStock;
    private String image;
    private CategoryDto category;
    private BrandDto brand;
    private SupplierDto supplier;
}

