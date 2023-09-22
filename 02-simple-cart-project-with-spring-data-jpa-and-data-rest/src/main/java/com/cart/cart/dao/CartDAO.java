package com.cart.cart.dao;

import com.cart.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Cart, Integer> {

}
