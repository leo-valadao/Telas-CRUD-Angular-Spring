package com.leonardo.Spring.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/api/v1/sale")
public class SaleResource {

    // Objetcs
    @Autowired
    private SaleService saleService;

    // API's
    // Get All Sale(s)
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {

        List<Sale> sales = saleService.findAllSales();

        if (!sales.isEmpty()) {
            return new ResponseEntity<List<Sale>>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Sale>>(HttpStatus.NO_CONTENT);
        }
    }

    // Get Sale by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable("id") Long id) {

        Sale sale = saleService.findSaleById(id);

        if (sale != null) {
            return new ResponseEntity<Sale>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Sale
    @PostMapping
    public ResponseEntity<Void> addSale(@RequestBody @Valid Sale sale) {

        saleService.saveSale(sale);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // Update Sale
    @PutMapping
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale) {

        Sale oldSale = saleService.findSaleById(sale.getId());

        if (oldSale != null) {
            saleService.saveSale(sale);
            return new ResponseEntity<Sale>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Sale
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable("id") Long id) {

        Sale oldSale = saleService.findSaleById(id);

        if (oldSale != null) {
            saleService.deleteSaleById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
