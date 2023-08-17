package com.universal.product.repository;

import com.universal.product.dto.SupplierProductCountDto;
import com.universal.product.entity.Product;
import com.universal.product.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT s.companyName, COUNT(p.id) FROM Supplier s JOIN s.products p GROUP BY s.companyName")
    List<Object[]> countProductsBySupplier();


}


