package com.universal.product.dto;

import lombok.Data;

@Data
public class SupplierProductCountDto {
    private String companyName;
    private Long productCount;

    public SupplierProductCountDto(String companyName, Long productCount) {
        this.companyName = companyName;
        this.productCount = productCount;
    }
}
