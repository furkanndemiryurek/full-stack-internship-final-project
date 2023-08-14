package com.universal.product.dto;

import lombok.Data;

@Data
public class SupplierDto {
    private Long id;
    private String companyName;
    private SupplierDetailDto supplierDetail;
}
