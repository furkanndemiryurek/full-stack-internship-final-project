package com.universal.product.service.concretes;

import com.universal.product.dto.BrandDto;
import com.universal.product.entity.Brand;
import com.universal.product.repository.BrandRepository;
import com.universal.product.service.abstracts.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandDto> findAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> dtos = brands.stream().map(brand -> modelMapper.map(
                brand, BrandDto.class
        )).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public BrandDto findById(Long id) {
        Optional<Brand> tempBrand = brandRepository.findById(id);
        if (tempBrand.isPresent())
            return modelMapper.map(tempBrand, BrandDto.class);

        return null;
    }

    @Override
    public BrandDto add(BrandDto entity) {
        Brand tempBrand = modelMapper.map(entity, Brand.class);
        brandRepository.save(tempBrand);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Brand> tempBrand = brandRepository.findById(id);
        if (tempBrand.isPresent())
            brandRepository.deleteById(id);
    }

    @Override
    public BrandDto update(BrandDto entity) {
        Brand tempBrand = brandRepository.findById(entity.getId()).get();
        tempBrand.setBrandName(entity.getBrandName());
        brandRepository.save(tempBrand);
        return entity;
    }
}
