package com.universal.product.service.abstracts;

import com.universal.product.dto.ProductDto;

import java.util.List;

public interface ProductService extends GenericService<ProductDto> {
     List<ProductDto> findProductsBySupplierId(Long supplierId);

     List<ProductDto> findByCategoryId(Long categoryId);

     List<ProductDto> findByBrandId(Long brandId);
     List<ProductDto> criticalStock();
}
