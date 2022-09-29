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

import com.leonardo.Spring.domain.ShoppingCart;
import com.leonardo.Spring.service.ShoppingCartService;

@RestController
@RequestMapping(path = "/api/v1/shoppingcart")
public class ShoppingCartResource {

    // Objetcs
    @Autowired
    private ShoppingCartService shoppingCartService;

    // API's
    // Get All Shopping Cart
    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAllShoppingCarts() {
        
        List<ShoppingCart> shoppingCarts = shoppingCartService.findAllShoppingCarts();

        if (!shoppingCarts.isEmpty()) {
            return new ResponseEntity<List<ShoppingCart>>(shoppingCarts, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<ShoppingCart>>(HttpStatus.NO_CONTENT);
        }
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
    public ResponseEntity<Void> addShoppingCart(@RequestBody @Valid ShoppingCart shoppingCart) {
        
        shoppingCartService.saveShoppingCart(shoppingCart);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // Update Shopping Cart
    @PutMapping
    public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart) {
         
        ShoppingCart oldShoppingCart = shoppingCartService.findShoppingCartById(shoppingCart.getId());

        if (oldShoppingCart != null) {
            shoppingCartService.saveShoppingCart(shoppingCart);
            return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<ShoppingCart>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Shopping Cart
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteShoppingCart(@PathVariable("id") Long id) {
       
        ShoppingCart oldShoppingCart = shoppingCartService.findShoppingCartById(id);

        if (oldShoppingCart != null) {
            shoppingCartService.deleteShoppingCartById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
