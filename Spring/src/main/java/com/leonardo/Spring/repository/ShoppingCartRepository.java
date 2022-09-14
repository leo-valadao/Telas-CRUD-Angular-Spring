package com.leonardo.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonardo.Spring.domain.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query(value = "SELECT sc FROM ShoppingCart sc WHERE sc.sale.id = ?1")
    List<ShoppingCart> findAllBySale(long saleId);
}
