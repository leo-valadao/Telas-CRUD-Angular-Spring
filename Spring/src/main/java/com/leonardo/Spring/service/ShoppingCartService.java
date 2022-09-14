package com.leonardo.Spring.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.Spring.domain.ShoppingCart;
import com.leonardo.Spring.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    // Objetcs
    // Shopping Cart Repository
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    // Methods
    // Get All Shopping Cart
    public List<ShoppingCart> findAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    // Get All Shopping Carts From Specific Sale
    public List<ShoppingCart> findAllShoppingCartsFromSale(Long id) {
        return shoppingCartRepository.findAllBySale(id);
    }

    // Get Shopping Cart by ID
    public ShoppingCart findShoppingCartById(Long id) {
        try {
            return shoppingCartRepository.findById(id).get();
        } catch (Exception e) {
            throw new NoSuchElementException("Couldn't Find Shopping Cart! ID: " + id + " Exception: " + e);
        }
    }

    // Save Shopping Cart
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    // Delete Shopping Cart
    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
