package com.leonardo.Spring.resource;

import java.util.List;

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

import com.leonardo.Spring.domain.ShoppingCart;
import com.leonardo.Spring.service.ShoppingCartService;

@RestController
@RequestMapping(path = "/api/shoppingcart")
public class ShoppingCartResource {

    // Objetcs
    @Autowired
    private ShoppingCartService shoppingCartService;

    // API's
    // Get All Shopping Cart
    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCarts() {
        return new ResponseEntity<List<ShoppingCart>>(shoppingCartService.findAllShoppingCarts(), HttpStatus.OK);
    }

    // Get Shopping Cart by ID
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable("id") Long id) {
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(id);
        if (shoppingCart != null) {
            return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<ShoppingCart>(HttpStatus.NOT_FOUND);
        }
    }

    // Save Shopping Cart
    @PostMapping
    public ResponseEntity<ShoppingCart> addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return new ResponseEntity<ShoppingCart>(shoppingCartService.saveShoppingCart(shoppingCart), HttpStatus.CREATED);
    }

    // Update Shopping Cart
    @PutMapping
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart oldShoppingCart = shoppingCartService.findShoppingCartById(shoppingCart.getId());
        if (oldShoppingCart != null) {
            return new ResponseEntity<ShoppingCart>(shoppingCartService.saveShoppingCart(shoppingCart), HttpStatus.OK);
        } else {
            return new ResponseEntity<ShoppingCart>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Shopping Cart
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteShoppingCart(@PathVariable("id") Long id) {
        try {
            shoppingCartService.deleteShoppingCartById(id);
            return new ResponseEntity<String>("Shopping Cart Successfully Deleted! ID: " + id, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<String>(
                    "Failed to Delete Shopping Cart Due to Data Integrity Violation! ID: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("Failed to Delete Shopping Cart Due to Not Finding It! ID: " + id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
