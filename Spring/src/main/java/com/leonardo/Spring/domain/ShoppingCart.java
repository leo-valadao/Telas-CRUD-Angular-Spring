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
@Table(name = "shoppingcart")
public class ShoppingCart {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Quantity - Integer - Not Nullable
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Sale - Sale - Not Nullable - Foreign Key
    @OneToOne
    @JoinColumn(name = "fk_sale_id", referencedColumnName = "id")
    private Sale sale;

    // Product - Product - Not Nullable - Foreign Key
    @OneToOne
    @JoinColumn(name = "fk_product_id", referencedColumnName = "id")
    private Product product;

    // Getters and Setters
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Quantity
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Sale
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    // Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // To String
    @Override
    public String toString() {
        return "ShoppingCart [id=" + id + ", product=" + product + ", quantity=" + quantity + ", sale=" + sale + "]";
    }
}
