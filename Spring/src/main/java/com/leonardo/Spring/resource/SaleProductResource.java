package com.leonardo.Spring.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.Spring.domain.SaleProduct;
import com.leonardo.Spring.service.SaleProductService;

@RestController
@RequestMapping(path = "/api/saleproducts")
public class SaleProductResource {

    // Objetcs
    @Autowired
    private SaleProductService saleProductService;

    // API's
    // Get All Sale's Product(s)
    @GetMapping
    public ResponseEntity<List<SaleProduct>> getAllSaleProducts() {
        return new ResponseEntity<List<SaleProduct>>(saleProductService.findAllSaleProducts(), HttpStatus.OK);
    }

    // Get Sale's Product(s) by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<SaleProduct>> getSaleProductById(@PathVariable("id") Long id) {
        Optional<SaleProduct> saleProduct = saleProductService.findSaleProductById(id);
        if (saleProduct.isPresent()) {
            return new ResponseEntity<Optional<SaleProduct>>(saleProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<SaleProduct>>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Sale's Product(s)
    @PostMapping
    public ResponseEntity<SaleProduct> addSaleProduct(@RequestBody SaleProduct saleProduct) {
        return new ResponseEntity<SaleProduct>(saleProductService.saveSaleProduct(saleProduct), HttpStatus.CREATED);
    }

    // Update Sale's Product(s)
    @PutMapping
    public ResponseEntity<SaleProduct> updateSaleProduct(@RequestBody SaleProduct saleProduct) {
        Optional<SaleProduct> oldSaleProduct = saleProductService.findSaleProductById(saleProduct.getId());
        if (oldSaleProduct.isPresent()) {
            return new ResponseEntity<SaleProduct>(saleProductService.saveSaleProduct(saleProduct), HttpStatus.OK);
        } else {
            return new ResponseEntity<SaleProduct>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Sale's Product(s)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSaleProduct(@PathVariable("id") Long id) {
        try {
            saleProductService.deleteSaleProductById(id);
            return new ResponseEntity<String>("Sale's Product(s) Successfully Deleted! ID: " + id, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>(
                    "Failed to Delete Sale's Product(s) Due to Data Integrity Violation! ID: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("Failed to Delete Sale's Product(s) Due to Not Finding It! ID: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
