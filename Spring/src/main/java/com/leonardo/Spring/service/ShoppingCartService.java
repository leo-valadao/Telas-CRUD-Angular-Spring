package com.leonardo.Spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
    public Optional<ShoppingCart> findShoppingCartById(Long id) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        if (shoppingCart.isPresent()) {
            return shoppingCart;
        } else {
            throw new EntityNotFoundException("Shopping Cart Not Found! ID: " + id);
        }
    }

    // Save Shopping Cart
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.setProductPrice(shoppingCart.getProduct().getPrice() * shoppingCart.getQuantity());
        return shoppingCartRepository.save(shoppingCart);
    }

    // Delete Shopping Cart
    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
