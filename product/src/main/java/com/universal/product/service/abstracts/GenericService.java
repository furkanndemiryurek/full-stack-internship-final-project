package com.universal.product.service.abstracts;


import com.universal.product.dto.ProductDto;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface GenericService<T>{
    List<T> findAll();

    T findById(Long id);

    T add(T entity);

    void deleteById(Long id);

    T update(T entity);
}
