package com.leonardo.Spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Name - String - Not Nullable
    @Column(name = "name", nullable = false)
    private String name;

    // Price - Double - Not Nullable
    @Column(name = "price", nullable = false)
    private Double price;

    // Description - String - Nullable
    @Column(name = "description", nullable = true)
    private String description;

    // Getters and Setters
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // To String
    @Override
    public String toString() {
        return "Product [description=" + description + ", id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
