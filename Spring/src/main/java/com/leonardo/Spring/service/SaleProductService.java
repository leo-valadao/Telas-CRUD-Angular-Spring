package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.SaleProduct;
import com.leonardo.Spring.repository.SaleProductRepository;

@Service
public class SaleProductService {

    // Objetcs
    // Sale's Product(s) Repository
    @Autowired
    private SaleProductRepository saleProductRepository;

    // Methods
    // Get All Sale's Product(s)
    public List<SaleProduct> findAllSaleProducts() {
        return saleProductRepository.findAll();
    }

    // Get Sale's Product(s) by ID
    public Optional<SaleProduct> findSaleProductById(Long id) {
        Optional<SaleProduct> saleProduct = saleProductRepository.findById(id);
        if (saleProduct.isPresent()) {
            return saleProduct;
        } else {
            throw new EntityNotFoundException("Sale's Product(s) Not Found! ID: " + id);
        }
    }

    // Save Sale's Product(s)
    public SaleProduct saveSaleProduct(SaleProduct saleProduct) {
        return saleProductRepository.save(saleProduct);
    }

    // Delete Sale's Product(s)
    public void deleteSaleProductById(Long id) {
        saleProductRepository.deleteById(id);
    }
}
