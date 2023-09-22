package com.cart.cart.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Items")
public class Item {

    // Defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int itemId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Constructors
    public Item(){

    }

    public Item(String name, double price, Cart cart) {
        this.name = name;
        this.price = price;
        this.cart = cart;
    }

    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
