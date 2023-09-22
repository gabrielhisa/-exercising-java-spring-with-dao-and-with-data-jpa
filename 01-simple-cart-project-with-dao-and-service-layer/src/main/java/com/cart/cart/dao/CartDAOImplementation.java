package com.cart.cart.dao;

import com.cart.cart.entity.Cart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAOImplementation implements CartDAO{

    // Defining the entity manager
    private EntityManager entityManager;

    // Constructor injection
    @Autowired
    public CartDAOImplementation (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Cart> findAll() {

        // Creating the query
        TypedQuery<Cart> query = entityManager.createQuery("FROM Cart", Cart.class);

        // Returning the list created from the query
        return query.getResultList();
    }

    @Override
    public Cart findById(int theId) {
        // Returning the straight result of finding the object by Id
        return entityManager.find(Cart.class, theId);
    }

    @Override
    public Cart save(Cart theCart) {
        // If Id==0, will insert/save, else will update existing object
        return entityManager.merge(theCart);
    }

    @Override
    public void deleteById(int theId) {
        // This one finds the object by id and deletes it
        Cart cart = entityManager.find(Cart.class, theId);
        entityManager.remove(cart);
    }
}
