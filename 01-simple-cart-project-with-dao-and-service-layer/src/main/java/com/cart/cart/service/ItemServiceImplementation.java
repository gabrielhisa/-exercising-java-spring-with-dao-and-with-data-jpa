package com.cart.cart.service;

import com.cart.cart.dao.ItemDAO;
import com.cart.cart.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemServiceImplementation implements ItemService{

    private ItemDAO itemDAO;

    @Autowired
    public ItemServiceImplementation(ItemDAO theItemDAO){
        itemDAO = theItemDAO;
    }


    @Override
    public List<Item> findAll() {
        return itemDAO.findAll();
    }

    @Override
    public Item findById(int theId) {
        return itemDAO.findById(theId);
    }

    @Override
    @Transactional
    public Item save(Item theItem) {
        return itemDAO.save(theItem);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        itemDAO.deleteById((theId));
    }
}
