package com.leonardo.Spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sale")
public class Sale {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Customer - Customer - Not Nullable - Foreign Key
    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_customer_id", referencedColumnName = "id")
    private Customer customer;

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

    // To String
    @Override
    public String toString() {
        return "Sale [customer=" + customer + ", id=" + id + "]";
    }
}
