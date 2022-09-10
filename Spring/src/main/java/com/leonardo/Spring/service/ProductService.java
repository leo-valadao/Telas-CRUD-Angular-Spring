package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
    public Optional<Product> findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product;
        } else {
            throw new EntityNotFoundException("Product Not Found! ID: " + id);
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
