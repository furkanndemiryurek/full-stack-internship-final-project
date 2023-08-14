package com.universal.product.service.abstracts;

import com.universal.product.dto.ProductDto;

import java.util.List;

public interface ProductService extends GenericService<ProductDto> {
    public List<ProductDto> findProductsBySupplierId(Long supplierId);
}
