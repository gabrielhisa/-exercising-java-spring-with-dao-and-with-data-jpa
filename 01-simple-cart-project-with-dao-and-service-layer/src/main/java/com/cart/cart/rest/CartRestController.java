package com.cart.cart.rest;


import com.cart.cart.entity.Cart;
import com.cart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartRestController {

    // Instantiating the interface for methods
    private CartService cartService;

    @Autowired
    public CartRestController(CartService theCartService){
        cartService = theCartService;
    }

    // Exposing "/all" endpoint
    @GetMapping("/all")
    public List<Cart> findAll(){
        return cartService.findAll();
    };

    // Add mapping for GET "/cart/{cartId}"
    @GetMapping("/cart/{cartId}")
    public Cart getCart(@PathVariable int cartId){

        Cart theCart = cartService.findById(cartId);

        if (theCart == null) {
            throw new RuntimeException("Cart id not found - " + theCart);
        }

        return theCart;
    }

    // Add mapping for POST /cart - add a new cart
    @PostMapping("/cart")
    public Cart addCart(@RequestBody Cart theCart){

        // Just in case an id is passed in JSON, setting id to 0
        theCart.setCartId(0);

        // This is to force a save of new item, instead of update
        Cart dbCart = cartService.save(theCart);

        return dbCart;
    }

    // Add mapping for PUT /cart - update existing cart
    @PutMapping("/cart")
    public Cart updateCart(@RequestBody Cart theCart){

        Cart dbCart = cartService.save(theCart);

        return dbCart;
    }

    // Add mapping for DELETE /cart/{cartId} - delete cart
    @DeleteMapping("/cart/{cartId}")
    public String deleteCart(@PathVariable int cartId){

        Cart tempCart = cartService.findById(cartId);

        // Throw exception if null
        if (tempCart == null){
            throw new RuntimeException("Cart id not found - " + cartId);
        }

        cartService.deleteById(cartId);

        return "Deleted cart of - " + cartId;
    }
}
