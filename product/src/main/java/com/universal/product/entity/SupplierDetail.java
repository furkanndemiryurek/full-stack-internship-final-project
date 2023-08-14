package com.universal.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "supplier_details")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SupplierDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String city;
    private String district;
    private String address;
    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "supplierDetail")
    @JsonIgnore
    private Supplier supplier;

    public SupplierDetail(String city, String district, String address, String phone, String email) {
        this.city = city;
        this.district = district;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
