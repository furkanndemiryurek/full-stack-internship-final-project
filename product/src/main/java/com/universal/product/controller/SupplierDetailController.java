package com.universal.product.controller;

import com.universal.product.dto.BrandDto;
import com.universal.product.dto.SupplierDetailDto;
import com.universal.product.entity.SupplierDetail;
import com.universal.product.service.abstracts.BrandService;
import com.universal.product.service.abstracts.SupplierDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/suppliers/details")
public class SupplierDetailController {

    @Autowired
    SupplierDetailService supplierDetailService;

    @GetMapping
    public List<SupplierDetailDto> findAll(){
        return supplierDetailService.findAll();
    }

    @GetMapping("/{supplierDetailId}")
    public SupplierDetailDto findById(@PathVariable("supplierDetailId")Long brandId){
        return supplierDetailService.findById(brandId);
    }

    @PostMapping
    public SupplierDetailDto add(@RequestBody SupplierDetailDto supplierDetail){
        return add(supplierDetail);
    }

    @DeleteMapping("/{supplierDetailId}")
    public void deleteById(@PathVariable("supplierDetailId")Long supplierDetailId) {supplierDetailService.deleteById(supplierDetailId);}

}
