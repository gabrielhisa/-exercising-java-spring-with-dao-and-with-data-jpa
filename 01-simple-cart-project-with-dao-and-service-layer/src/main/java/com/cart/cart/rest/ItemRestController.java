package com.cart.cart.rest;

import com.cart.cart.entity.Item;
import com.cart.cart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemRestController {

    // Instantiating the interface for methods
    private ItemService itemService;

    @Autowired
    public ItemRestController(ItemService theItemService){
        itemService = theItemService;
    }

    // Exposing "/all" endpoint
    @GetMapping("/all")
    public List<Item> findAll(){
        return itemService.findAll();
    };

    // Add mapping for GET "/item/{itemId}"
    @GetMapping("/item/{itemId}")
    public Item getItem(@PathVariable int itemId){

        Item theItem = itemService.findById(itemId);

        if (theItem == null) {
            throw new RuntimeException("Item id not found - " + theItem);
        }

        return theItem;
    }

    // Add mapping for POST /item - add a new item
    @PostMapping("/item")
    public Item addItem(@RequestBody Item theItem){

        // Just in case an id is passed in JSON, setting id to 0
        theItem.setItemId(0);

        // This is to force a save of new item, instead of update
        Item dbItem = itemService.save(theItem);

        return dbItem;
    }

    // Add mapping for PUT /item - update existing item
    @PutMapping("/item")
    public Item updateItem(@RequestBody Item theItem){

        Item dbItem = itemService.save(theItem);

        return dbItem;
    }

    // Add mapping for DELETE /item/{itemId} - delete item
    @DeleteMapping("/item/{itemId}")
    public String deleteItem(@PathVariable int itemId){

        Item tempItem = itemService.findById(itemId);

        // Throw exception if null
        if (tempItem == null){
            throw new RuntimeException("Item id not found - " + itemId);
        }

        itemService.deleteById(itemId);

        return "Deleted item of - " + itemId;
    }
}
