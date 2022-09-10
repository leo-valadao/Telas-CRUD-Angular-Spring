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

import com.leonardo.Spring.domain.Sale;
import com.leonardo.Spring.service.SaleService;

@RestController
@RequestMapping(path = "/api/sale")
public class SaleResource {

    // Objetcs
    @Autowired
    private SaleService saleService;

    // API's
    // Get All Sale(s)
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return new ResponseEntity<List<Sale>>(saleService.findAllSales(), HttpStatus.OK);
    }

    // Get Sale by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<Sale>> getSaleById(@PathVariable("id") Long id) {
        Optional<Sale> sale = saleService.findSaleById(id);
        if (sale.isPresent()) {
            return new ResponseEntity<Optional<Sale>>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Sale>>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Sale
    @PostMapping
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
        return new ResponseEntity<Sale>(saleService.saveSale(sale), HttpStatus.CREATED);
    }

    // Update Sale
    @PutMapping
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale) {
        Optional<Sale> oldSale = saleService.findSaleById(sale.getId());
        if (oldSale.isPresent()) {
            return new ResponseEntity<Sale>(saleService.saveSale(sale), HttpStatus.OK);
        } else {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Sale
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable("id") Long id) {
        try {
            saleService.deleteSaleById(id);
            return new ResponseEntity<String>("Sale Successfully Deleted! ID: " + id, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>("Failed to Delete Sale Due to Data Integrity Violation! ID: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("Failed to Delete Sale Due to Not Finding It! ID: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
