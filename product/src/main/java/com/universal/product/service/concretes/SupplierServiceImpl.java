package com.universal.product.service.concretes;

import com.universal.product.dto.SupplierDetailDto;
import com.universal.product.dto.SupplierDto;
import com.universal.product.dto.SupplierProductCountDto;
import com.universal.product.entity.Supplier;
import com.universal.product.entity.SupplierDetail;
import com.universal.product.repository.SupplierRepository;
import com.universal.product.service.abstracts.SupplierService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    private final ModelMapper modelMapper;

    public SupplierServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SupplierDto> findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDto> dtos = suppliers.stream().map(supplier ->
                modelMapper.map(supplier, SupplierDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public SupplierDto findById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        SupplierDto tempSupplierDto;
        if (supplier.isPresent())
        {
            tempSupplierDto = modelMapper.map(supplier, SupplierDto.class);
            return tempSupplierDto;
        }
        return null;
    }

    @Override
    public SupplierDto add(SupplierDto entity) {
        Supplier tempSupplier = new Supplier();
        SupplierDetail tempDetail = new SupplierDetail();
        tempSupplier.setCompanyName(entity.getCompanyName());
        tempDetail.setCity(entity.getSupplierDetail().getCity());
        tempDetail.setDistrict(entity.getSupplierDetail().getDistrict());
        tempDetail.setAddress(entity.getSupplierDetail().getAddress());
        tempDetail.setPhone(entity.getSupplierDetail().getPhone());
        tempDetail.setEmail(entity.getSupplierDetail().getEmail());
        tempSupplier.setSupplierDetail(tempDetail);
        supplierRepository.save(tempSupplier);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Supplier supplier = supplierRepository.findById(id).get();
        supplierRepository.deleteById(id);
    }


    @Override
    public SupplierDto update(SupplierDto entity) {
        Supplier tempSupplier = supplierRepository.findById(entity.getId()).get();
        tempSupplier.setCompanyName(entity.getCompanyName());
        tempSupplier.getSupplierDetail().setCity(entity.getSupplierDetail().getCity());
        tempSupplier.getSupplierDetail().setDistrict(entity.getSupplierDetail().getDistrict());
        tempSupplier.getSupplierDetail().setAddress(entity.getSupplierDetail().getAddress());
        tempSupplier.getSupplierDetail().setPhone(entity.getSupplierDetail().getPhone());
        tempSupplier.getSupplierDetail().setEmail(entity.getSupplierDetail().getEmail());
        supplierRepository.save(tempSupplier);
        return entity;
    }


}
