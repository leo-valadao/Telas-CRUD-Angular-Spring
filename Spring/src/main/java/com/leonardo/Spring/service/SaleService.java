package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.Sale;
import com.leonardo.Spring.repository.SaleRepository;

@Service
public class SaleService {

    // Objetcs
    // Sale Repository
    @Autowired
    private SaleRepository saleRepository;

    // Methods
    // Get All Sale
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    // Get Sale by ID
    public Sale findSaleById(Long id) {
        try {
            return saleRepository.findById(id).get();
        } catch (Exception e) {
            throw new NoSuchElementException("Couldn't Find Sale! ID: " + id + " Exception: " + e);
        }
    }

    // Save Sale
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    // Delete Sale
    public void deleteSaleById(Long id) {
        saleRepository.deleteById(id);
    }
}
