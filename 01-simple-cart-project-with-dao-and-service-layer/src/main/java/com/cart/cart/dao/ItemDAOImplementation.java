package com.cart.cart.dao;


import com.cart.cart.entity.Cart;
import com.cart.cart.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImplementation implements ItemDAO{

    // Defining the entity manager
    private EntityManager entityManager;

    // Constructor injection
    @Autowired
    public ItemDAOImplementation (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Item> findAll() {

        // Creating the query
        TypedQuery<Item> query = entityManager.createQuery("FROM Item", Item.class);

        // Returning the list created from the query
        return query.getResultList();
    }

    @Override
    public Item findById(int theId) {
        return entityManager.find(Item.class, theId);
    }

    @Override
    public Item save(Item theItem) {
        return entityManager.merge(theItem);
    }

    @Override
    public void deleteById(int theId) {
        Item item = entityManager.find(Item.class, theId);
        entityManager.remove(item);
    }
}
