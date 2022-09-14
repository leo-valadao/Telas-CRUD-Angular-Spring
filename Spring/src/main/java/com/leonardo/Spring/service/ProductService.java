package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.Product;
import com.leonardo.Spring.repository.ProductRepository;

@Service
public class ProductService {

    // Objetcs
    // Product Repository
    @Autowired
    private ProductRepository productRepository;

    // Methods
    // Get All Product(s)
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // Get Product by ID
    public Product findProductById(Long id) {
        try {
            return productRepository.findById(id).get();    
        } catch (Exception e) {
            throw new NoSuchElementException("Couldn't Find Product! ID: " + id+" Exception: " +e);
        }
    }

    // Save Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete Product
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
