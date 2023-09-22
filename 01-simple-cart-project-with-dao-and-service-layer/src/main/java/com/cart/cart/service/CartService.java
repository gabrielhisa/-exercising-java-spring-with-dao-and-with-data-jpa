package com.cart.cart.service;

import com.cart.cart.entity.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findAll();

    Cart findById(int theId);

    Cart save(Cart theCart);

    void deleteById(int theId);
}
