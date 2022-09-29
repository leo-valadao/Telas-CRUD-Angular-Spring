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

import com.leonardo.Spring.domain.Product;
import com.leonardo.Spring.service.ProductService;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductResource {

    // Objetcs
    @Autowired
    private ProductService productService;

    // API's
    // Get All Product(s)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.findAllProducts();

        if (!products.isEmpty()) {
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
    }

    // Get Product by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {

        Product product = productService.findProductById(id);

        if (product != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Product
    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody @Valid Product product) {

        productService.saveProduct(product);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // Update Product
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        
        Product oldProduct = productService.findProductById(product.getId());

        if (oldProduct != null) {
            productService.saveProduct(product);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Product
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        
        Product oldProduct = productService.findProductById(id);

        if (oldProduct != null) {
            productService.deleteProductById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
