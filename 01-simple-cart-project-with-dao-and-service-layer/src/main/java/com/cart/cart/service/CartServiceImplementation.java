package com.cart.cart.service;

import com.cart.cart.dao.CartDAO;
import com.cart.cart.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService{

    private CartDAO cartDAO;

    @Autowired
    public CartServiceImplementation(CartDAO theCartDAO){
        cartDAO = theCartDAO;
    }

    @Override
    public List<Cart> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public Cart findById(int theId) {
        return cartDAO.findById(theId);
    }

    @Transactional
    @Override
    public Cart save(Cart theCart) {
        return cartDAO.save(theCart);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        cartDAO.deleteById(theId);
    }
}
