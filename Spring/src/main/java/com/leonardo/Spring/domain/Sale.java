package com.leonardo.Spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Customer - Customer - Not Nullable - Foreign Key
    @OneToOne
    @JoinColumn(name = "fk_customer_id", referencedColumnName = "id")
    private Customer customer;

    // Total Price - Double - Not Nullable
    @Column(name = "totalprice", nullable = false)
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

    // Total Price
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
