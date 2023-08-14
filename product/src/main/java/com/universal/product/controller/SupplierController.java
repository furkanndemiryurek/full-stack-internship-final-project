package com.universal.product.controller;

import com.universal.product.dto.SupplierDto;
import com.universal.product.service.abstracts.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("suppliers",supplierService.findAll());
        return "suppliers/suppliers.html";
    }

    @GetMapping("/{supplierId}")
    public SupplierDto findById(@PathVariable("supplierId")Long supplierId){
        return supplierService.findById(supplierId);
    }

    @PostMapping("/save")
    public String add(@ModelAttribute SupplierDto supplierDto){
         supplierService.add(supplierDto);
         return "redirect:/suppliers";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute SupplierDto supplierDto){
        supplierService.update(supplierDto);
        return "redirect:/suppliers";
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam("supplierId") Long supplierId) {
        supplierService.deleteById(supplierId);
        return "redirect:/suppliers";
    }

}
