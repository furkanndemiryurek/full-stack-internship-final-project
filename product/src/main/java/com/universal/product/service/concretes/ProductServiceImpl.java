package com.universal.product.service.concretes;

import com.universal.product.dto.*;
import com.universal.product.entity.Category;
import com.universal.product.entity.Product;
import com.universal.product.repository.BrandRepository;
import com.universal.product.repository.CategoryRepository;
import com.universal.product.repository.ProductRepository;
import com.universal.product.repository.SupplierRepository;
import com.universal.product.service.abstracts.BrandService;
import com.universal.product.service.abstracts.CategoryService;
import com.universal.product.service.abstracts.ProductService;
import com.universal.product.service.abstracts.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;


    public ProductServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> dtos = products.stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public ProductDto findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return modelMapper.map(product, ProductDto.class);
        }
        return null;
    }

    @Override
    public ProductDto add(ProductDto productDto) {
        Product product = new Product();
        product.setCategory(categoryRepository.findById(productDto.getCategory().getId()).get());
        product.setBrand(brandRepository.findById(productDto.getBrand().getId()).get());
        product.setSupplier(supplierRepository.findById(productDto.getSupplier().getId()).get());
        product.setProductName(productDto.getProductName());
        product.setImage(productDto.getImage());
        product.setUnitsInStock(productDto.getUnitsInStock());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setDescription(productDto.getDescription());
        productRepository.save(product);
        return productDto;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
            productRepository.deleteById(id);
    }

    @Override
    public ProductDto update(ProductDto entity) {
        Product product = productRepository.findById(entity.getId()).get();
        if (entity.getCategory() != null)
            product.setCategory(categoryRepository.findById(entity.getCategory().getId()).get());

        if (entity.getBrand() != null)
            product.setBrand(brandRepository.findById(entity.getBrand().getId()).get());

        if (entity.getSupplier() != null)
            product.setSupplier(supplierRepository.findById(entity.getSupplier().getId()).get());

        product.setProductName(entity.getProductName());
        product.setImage(entity.getImage());
        product.setUnitsInStock(entity.getUnitsInStock());
        product.setUnitPrice(entity.getUnitPrice());
        product.setDescription(entity.getDescription());
        productRepository.save(product);

        return entity;
    }


    public List<ProductDto> findProductsBySupplierId(Long supplierId) {
        List<Product> products = productRepository.findBySupplierId(supplierId);
        List<ProductDto> dtos = products.stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return dtos;
    }
}
