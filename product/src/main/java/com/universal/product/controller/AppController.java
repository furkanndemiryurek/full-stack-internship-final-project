package com.universal.product.controller;

import com.universal.product.dto.SupplierProductCountDto;
import com.universal.product.service.concretes.BrandServiceImpl;
import com.universal.product.service.concretes.CategoryServiceImpl;
import com.universal.product.service.concretes.ProductServiceImpl;
import com.universal.product.service.concretes.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    ProductServiceImpl productService;
    CategoryServiceImpl categoryService;
    BrandServiceImpl brandService;
    SupplierServiceImpl supplierService;

    @Autowired
    public AppController(ProductServiceImpl productService, CategoryServiceImpl categoryService, BrandServiceImpl brandService, SupplierServiceImpl supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.supplierService = supplierService;
    }

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("productCount", productService.findAll().size());
        model.addAttribute("categoryCount", categoryService.findAll().size());
        model.addAttribute("brandCount", brandService.findAll().size());
        model.addAttribute("supplierCount", supplierService.findAll().size());
        model.addAttribute("products", productService.criticalStock());
        model.addAttribute("supplierProductCounts", supplierService.getSupplierProductCounts());
        return "home/index.html";
    }
}
