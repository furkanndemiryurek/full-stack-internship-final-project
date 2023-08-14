package com.universal.product.repository;

import com.universal.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products WHERE supplier_id=:supplierId",nativeQuery = true)
    List<Product> findBySupplierId(@Param("supplierId") Long supplierId);
}
