package com.universal.product.service.concretes;

import com.universal.product.dto.SupplierDetailDto;
import com.universal.product.entity.Supplier;
import com.universal.product.entity.SupplierDetail;
import com.universal.product.repository.SupplierDetailRepository;
import com.universal.product.service.abstracts.SupplierDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierDetailServiceImpl implements SupplierDetailService {

    @Autowired
    SupplierDetailRepository supplierDetailRepository;

    private final ModelMapper modelMapper;

    public SupplierDetailServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public List<SupplierDetailDto> findAll() {
        List<SupplierDetail> suppliers = supplierDetailRepository.findAll();
        List<SupplierDetailDto> supplierDetailDtos = suppliers.stream().map(
                supplierDetail -> modelMapper.map(supplierDetail, SupplierDetailDto.class)
        ).collect(Collectors.toList());
        return supplierDetailDtos;
    }

    @Override
    public SupplierDetailDto findById(Long id) {
        Optional<SupplierDetail> supplierDetail = supplierDetailRepository.findById(id);
        if (supplierDetail.isPresent())
            return modelMapper.map(supplierDetail, SupplierDetailDto.class);
        return null;
    }

    @Override
    public SupplierDetailDto add(SupplierDetailDto entity) {
        SupplierDetail tempSupplierDetail = new SupplierDetail();
        tempSupplierDetail = modelMapper.map(entity, SupplierDetail.class);
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        Optional<SupplierDetail> supplierDetail = supplierDetailRepository.findById(id);
        if (supplierDetail.isPresent())
            supplierDetailRepository.deleteById(id);
    }

    @Override
    public SupplierDetailDto update(SupplierDetailDto entity) {
        return null;
    }
}
