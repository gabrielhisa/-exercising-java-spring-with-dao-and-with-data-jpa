package com.cart.cart.dao;

import com.cart.cart.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {

}
