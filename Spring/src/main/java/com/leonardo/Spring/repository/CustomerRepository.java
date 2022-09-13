package com.leonardo.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonardo.Spring.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM Customer WHERE email = ?1", nativeQuery = true)
    Customer findByEmail(String email) throws Exception;
}
