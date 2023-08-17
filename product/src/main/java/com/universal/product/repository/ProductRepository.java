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

    @Query(value = "SELECT * FROM products WHERE category_id=:categoryId",nativeQuery = true)
    List<Product> findByCategoryId(@Param("categoryId")Long categoryId);
    @Query(value = "SELECT * FROM products WHERE brand_id=:brandId",nativeQuery = true)
    List<Product> findByBrandId(Long brandId);

    @Query(value = "SELECT * FROM products WHERE units_in_stock < 10" +
            " ORDER BY units_in_stock ASC LIMIT 10", nativeQuery = true)
    List<Product> criticalStock();
}
