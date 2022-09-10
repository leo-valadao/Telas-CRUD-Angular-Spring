package com.leonardo.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.Spring.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
