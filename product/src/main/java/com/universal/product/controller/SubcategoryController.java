package com.universal.product.controller;


import com.universal.product.dto.SubcategoryDto;
import com.universal.product.entity.Subcategory;
import com.universal.product.service.abstracts.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories/sub")
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;

    @GetMapping
    public List<SubcategoryDto> findAll(){
        return subcategoryService.findAll();
    }

    @GetMapping("/{subId}")
    public SubcategoryDto findById(@PathVariable("subId")Long subId){
        return subcategoryService.findById(subId);
    }

    @PostMapping
    public SubcategoryDto add(@RequestBody SubcategoryDto subcategoryDto){
        return subcategoryService.add(subcategoryDto);
    }

    @DeleteMapping("/{subcategoryId}")
    public void deleteById(@PathVariable("subcategoryId") Long subcategoryId){subcategoryService.deleteById(subcategoryId);}
}
