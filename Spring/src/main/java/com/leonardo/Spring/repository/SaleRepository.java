package com.leonardo.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.Spring.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
