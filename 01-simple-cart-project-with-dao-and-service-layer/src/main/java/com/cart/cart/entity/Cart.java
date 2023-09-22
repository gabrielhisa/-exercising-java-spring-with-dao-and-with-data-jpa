package com.cart.cart.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Carts")
public class Cart {

    // Defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private int cartId;

    @Column(name="user_id")
    private int userId;

    @Column(name="cart_size")
    private String cartSize;

    @Column(name="cart_slots")
    private int cartSlots;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    // Constructors
    public Cart(){

    }

    public Cart(int userId, String cartSize, int cartSlots, List<Item> items) {
        this.userId = userId;
        this.cartSize = cartSize;
        this.cartSlots = cartSlots;
        this.items = items;
    }

    // Getters and setters
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCartSize() {
        return cartSize;
    }

    public void setCartSize(String cartSize) {
        this.cartSize = cartSize;
    }

    public int getCartSlots() {
        return cartSlots;
    }

    public void setCartSlots(int cartSlots) {
        this.cartSlots = cartSlots;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
