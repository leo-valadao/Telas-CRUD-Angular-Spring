package com.leonardo.Spring.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    // Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Name - String - Not Nullable
    @Column(name = "name", nullable = false)
    private String name;

    // E-Mail - String - Not Nullable
    @Column(name = "email", nullable = false)
    private String email;

    // Birth Date - Date (Java Util) - Nullable
    @Column(name = "birthdate", nullable = true)
    private LocalDate birthDate;

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

    // E-Mail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Birth Date
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
