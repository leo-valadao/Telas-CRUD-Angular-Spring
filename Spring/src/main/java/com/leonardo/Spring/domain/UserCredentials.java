package com.leonardo.Spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usercredentials")
public class UserCredentials {

    // Atributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Name - String - Not Nullable - Unique
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // E-Mail - String - Not Nullable - Unique
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Password - String - Not Nullable
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    // Role - String - Not Nullable
    @Column(name = "role", nullable = false)
    private String role;

    // Constructos
    // Empty Constructor
    public UserCredentials() {
    }

    // All Attributes Constructor
    public UserCredentials(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Name
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // E-Mail
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // To String
    @Override
    public String toString() {
        return "UserCredentials [email=" + email + ", id=" + id + ", password=" + password + ", username=" + username
                + "]";
    }
}
