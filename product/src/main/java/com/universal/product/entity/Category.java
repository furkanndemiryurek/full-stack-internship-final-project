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
@Table(name= "categories")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "category_name")
    private String categoryName;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "category")
    private List<Subcategory> subcategories;

    public void add(Product product){
        if (products == null)
            products = new ArrayList<>();

        products.add(product);
        product.setCategory(this);
    }

    public void add(Subcategory subcategory){
        if (subcategories == null)
            subcategories = new ArrayList<>();

        subcategories.add(subcategory);
        subcategory.setCategory(this);
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
