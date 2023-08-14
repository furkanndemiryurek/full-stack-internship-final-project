package com.universal.product.dto;

import lombok.Data;

@Data
public class SupplierDetailDto {
    private Long id;
    private String city;
    private String district;
    private String address;
    private String phone;
    private String email;
}
