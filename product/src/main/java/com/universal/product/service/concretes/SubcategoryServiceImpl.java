package com.universal.product.service.concretes;

import com.universal.product.dto.SubcategoryDto;
import com.universal.product.entity.Subcategory;
import com.universal.product.repository.SubcategoryRepository;
import com.universal.product.service.abstracts.SubcategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    SubcategoryRepository subcategoryRepository;

    private final ModelMapper modelMapper;

    public SubcategoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public List<SubcategoryDto> findAll() {
        List<Subcategory> subcategories = subcategoryRepository.findAll();
        List<SubcategoryDto> subcategoryDtos = subcategories.stream().map(
                subcategory -> modelMapper.map(subcategory, SubcategoryDto.class)
        ).collect(Collectors.toList());
        return subcategoryDtos;
    }

    @Override
    public SubcategoryDto findById(Long id) {
        Optional<Subcategory> subcategory = subcategoryRepository.findById(id);
        if (subcategory.isPresent()){
            return modelMapper.map(subcategory, SubcategoryDto.class);
        }
        return null;
    }

    @Override
    public SubcategoryDto add(SubcategoryDto entity) {
        Subcategory subcategory = new Subcategory();
        subcategory = modelMapper.map(entity, Subcategory.class);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Subcategory> tempSubcategory = subcategoryRepository.findById(id);
        if (tempSubcategory.isPresent())
            subcategoryRepository.deleteById(id);
    }

    @Override
    public SubcategoryDto update(SubcategoryDto entity) {
        return null;
    }
}
