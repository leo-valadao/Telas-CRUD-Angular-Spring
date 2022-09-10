package com.leonardo.Spring.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Sale {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Customer - Customer - Not Nullable -
    @OneToOne
    private Customer customer;
    // DEVE TER ESSA LINHA??? @Column(name = "customer", nullable = false)

    // Product(s) - Product - Not Nullable
    @OneToMany
    private List<Product> product;
    // DEVE TER ESSA LINHA??? @Column(name = "product", nullable = false)
    
    // Total Price - Double - Not Nullable
    @Column(name = "totalPrice", nullable = false)
    private Double totalPrice;

    // Getters and Setters
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Product(s)
    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    // Total Price
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
