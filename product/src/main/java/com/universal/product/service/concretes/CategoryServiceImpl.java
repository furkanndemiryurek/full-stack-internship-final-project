package com.universal.product.service.concretes;

import com.universal.product.dto.CategoryDto;
import com.universal.product.dto.ProductDto;
import com.universal.product.entity.Category;
import com.universal.product.repository.CategoryRepository;
import com.universal.product.service.abstracts.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public CategoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> dtos = categories.stream().map(category -> modelMapper.map(
                category, CategoryDto.class
        )).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public CategoryDto findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent())
            return modelMapper.map(category, CategoryDto.class);

        return null;
    }

    @Override
    public CategoryDto add(CategoryDto entity) {
        Category tempCategory = modelMapper.map(entity, Category.class);
        categoryRepository.save(tempCategory);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Category> tempCategory = categoryRepository.findById(id);
        if (tempCategory.isPresent())
            categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto update(CategoryDto entity) {
        Category category = categoryRepository.findById(entity.getId()).get();
        category.setCategoryName(entity.getCategoryName());
        categoryRepository.save(category);
        return entity;
    }
}
