package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.Sale;
import com.leonardo.Spring.domain.ShoppingCart;
import com.leonardo.Spring.repository.SaleRepository;
import com.leonardo.Spring.repository.ShoppingCartRepository;

@Service
public class SaleService {

    // Objetcs
    // Sale Repository
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ShoppingCartRepository saleCartRepository;

    // Methods
    // Get All Sale
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    // Get Total Price of Sale
    public Double getTotalPriceSale(Long saleId) {
        List<ShoppingCart> shoppinCartsList = saleCartRepository.findAllBySale(saleId);
        Double totalPriceSale = 0.0;
        for (ShoppingCart cart : shoppinCartsList) {
            totalPriceSale = totalPriceSale + cart.getProductPrice();
        }
        return totalPriceSale;
    }

    // Get Sale by ID
    public Optional<Sale> findSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            return sale;
        } else {
            throw new EntityNotFoundException("Sale Not Found! ID: " + id);
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
