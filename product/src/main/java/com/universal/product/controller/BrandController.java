package com.universal.product.controller;

import com.universal.product.dto.BrandDto;
import com.universal.product.entity.Brand;
import com.universal.product.service.abstracts.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("brands",brandService.findAll());
        return "brands/brands.html";
    }

    @GetMapping("/{brandId}")
    public BrandDto findById(@PathVariable("brandId")Long brandId){
        return brandService.findById(brandId);
    }

    @PostMapping("/save")
    public String add(@ModelAttribute BrandDto brandDto){
        brandService.add(brandDto);
        return "redirect:/brands";
    }

    @PostMapping("/update")
    public String updateProductFromForm(@ModelAttribute BrandDto brandDto) {
        brandService.update(brandDto);
        return "redirect:/brands";
    }

    @GetMapping("deleteById")
    public String deleteById(@RequestParam("brandId")Long brandId){
        brandService.deleteById(brandId);
        return "redirect:/brands";
    }

}
