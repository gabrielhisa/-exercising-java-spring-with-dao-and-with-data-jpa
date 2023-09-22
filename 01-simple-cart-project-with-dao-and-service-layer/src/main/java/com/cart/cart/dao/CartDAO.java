package com.cart.cart.dao;

import com.cart.cart.entity.Cart;
import com.cart.cart.entity.Item;

import java.util.List;

public interface CartDAO {

    List<Cart> findAll();

    Cart findById(int theId);

    Cart save(Cart theCart);

    void deleteById(int theId);

}
