package com.universal.product.controller;

import com.universal.product.dto.CategoryDto;
import com.universal.product.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "categories/categories.html";
    }

    @PostMapping("/save")
    public String addCategoryFromForm(@ModelAttribute CategoryDto categoryDto){
        categoryService.add(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/update")
    public String updateCategoryFromForm(@ModelAttribute CategoryDto categoryDto){
        categoryService.update(categoryDto);
        return "redirect:/categories";
    }
    @GetMapping("/{categoryId}")
    public CategoryDto findById(@PathVariable("categoryId")Long categoryId){
        return categoryService.findById(categoryId);
    }

    @GetMapping("deleteById")
    public String deleteById(@RequestParam("categoryId") Long categoryId) {
        categoryService.deleteById(categoryId);
        return "redirect:/categories";
    }

}
