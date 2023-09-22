package com.cart.cart.service;

import com.cart.cart.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findById(int theId);

    Item save(Item theItem);

    void deleteById(int theId);
}
