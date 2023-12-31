package com.universal.product.controller;

import com.universal.product.dto.CategoryDto;
import com.universal.product.dto.ProductAddDto;
import com.universal.product.dto.ProductDto;
import com.universal.product.dto.SupplierDto;
import com.universal.product.entity.Category;
import com.universal.product.entity.Product;
import com.universal.product.entity.Supplier;
import com.universal.product.service.concretes.BrandServiceImpl;
import com.universal.product.service.concretes.CategoryServiceImpl;
import com.universal.product.service.concretes.ProductServiceImpl;
import com.universal.product.service.concretes.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductServiceImpl productService;
    CategoryServiceImpl categoryService;
    BrandServiceImpl brandService;
    SupplierServiceImpl supplierService;

    @Autowired
    public ProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService
            , BrandServiceImpl brandService, SupplierServiceImpl supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.supplierService = supplierService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        return "/products/products.html";
    }

    @GetMapping("/supplier")
    public String findProductsBySupplierId(@RequestParam("supplierId")Long supplierId, Model model){
        model.addAttribute("products", productService.findProductsBySupplierId(supplierId));
        SupplierDto supplier = supplierService.findById(supplierId);
        model.addAttribute("sup", supplier);
        return "/products/products-2.html";
    }

    @GetMapping("/{productId}")
    public ProductDto findById(@PathVariable("productId") Long productId) {
        return productService.findById(productId);
    }


    @PostMapping("/save")
    public String addProductFromForm(@ModelAttribute ProductDto productDto, Model model) {
        productService.add(productDto);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProductFromForm(@ModelAttribute ProductDto productDto) {
        productService.update(productDto);
        return "redirect:/products";
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam("productId") Long productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }

    @GetMapping("/filterByCategory")
    @ResponseBody
    public List<List<Object>> filterByCategory(@RequestParam("categoryId") Long categoryId) {
        List<ProductDto> filteredProducts = productService.findByCategoryId(categoryId);
        List<List<Object>> data = new ArrayList<>();

        for (ProductDto product : filteredProducts) {
            List<Object> row = new ArrayList<>();
            row.add(product.getId());
            row.add(product.getImage());
            row.add(product.getProductName());
            row.add(product.getBrand().getBrandName());
            row.add(product.getCategory().getCategoryName());
            row.add(product.getUnitsInStock());
            row.add(product.getUnitPrice());
            row.add(product.getSupplier().getCompanyName());

            data.add(row);
        }

        return data;
    }

    @GetMapping("/filterByBrand")
    @ResponseBody
    public List<List<Object>> filterByBrand(@RequestParam("brandId") Long brandId) {
        List<ProductDto> filteredProducts = productService.findByBrandId(brandId);
        List<List<Object>> data = new ArrayList<>();

        for (ProductDto product : filteredProducts) {
            List<Object> row = new ArrayList<>();
            row.add(product.getId());
            row.add(product.getImage());
            row.add(product.getProductName());
            row.add(product.getBrand().getBrandName());
            row.add(product.getCategory().getCategoryName());
            row.add(product.getUnitsInStock());
            row.add(product.getUnitPrice());
            row.add(product.getSupplier().getCompanyName());

            data.add(row);
        }

        return data;
    }

    @GetMapping("/filterBySupllier")
    @ResponseBody
    public List<List<Object>> filterBySupplier(@RequestParam("supplierId") Long supplierId) {
        List<ProductDto> filteredProducts = productService.findByBrandId(supplierId);
        List<List<Object>> data = new ArrayList<>();
        for (ProductDto product : filteredProducts) {
            List<Object> row = new ArrayList<>();
            row.add(product.getId());
            row.add(product.getImage());
            row.add(product.getProductName());
            row.add(product.getBrand().getBrandName());
            row.add(product.getCategory().getCategoryName());
            row.add(product.getUnitsInStock());
            row.add(product.getUnitPrice());
            row.add(product.getSupplier().getCompanyName());

            data.add(row);
        }
        return data;
    }
}
