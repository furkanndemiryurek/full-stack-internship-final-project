package com.universal.product.converter;

import com.universal.product.dto.BrandDto;
import com.universal.product.dto.CategoryDto;
import com.universal.product.dto.ProductDto;
import com.universal.product.dto.SupplierDto;
import com.universal.product.entity.Product;
import org.modelmapper.ModelMapper;

public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto convertProductDto(Product product){
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        productDto.setCategory(modelMapper.map(product.getCategory(), CategoryDto.class));
        //productDto.setBrand(modelMapper.map(product.getBrand(), BrandDto.class));
        //productDto.setSupplier(modelMapper.map(product.getSupplier(), SupplierDto.class));
        return productDto;
    }
}
