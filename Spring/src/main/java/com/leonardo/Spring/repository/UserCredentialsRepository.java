package com.leonardo.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonardo.Spring.domain.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    @Query(value = "SELECT * FROM UserCredentials WHERE username = ?1", nativeQuery = true)
    UserCredentials findByUsename(String username) throws Exception;
}
