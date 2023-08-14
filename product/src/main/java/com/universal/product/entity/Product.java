package com.universal.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "products")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name= "product_name")
        private String productName;

        @Column(name = "description")
        private String description;

        @Column(name = "unit_price")
        private double unitPrice;

        @Column(name = "units_in_stock")
        private int unitsInStock;

        @Column(name = "image")
        private String image;

        @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name= "category_id")
        @JsonIgnore
        private Category category;

        @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name= "brand_id")
        @JsonIgnore
        private Brand brand;

        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinColumn(name = "supplier_id")
        @JsonIgnore
        private Supplier supplier;

    public Product(String productName, String description, double unitPrice, int unitsInStock, String image) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.image = image;
    }
}
