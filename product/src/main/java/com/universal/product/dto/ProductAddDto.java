package com.universal.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductAddDto {
    private Long id;
    private String productName;
    private String description;
    private double unitPrice;
    private int unitsInStock;
    private String image;
    private Long category;
    private Long brand;
    private Long supplier;
}
