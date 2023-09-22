package com.cart.cart.dao;

import com.cart.cart.entity.Cart;
import com.cart.cart.entity.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> findAll();

    Item findById(int theId);

    Item save(Item theItem);

    void deleteById(int theId);
}
