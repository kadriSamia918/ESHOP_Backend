package com.pcd.ecommerce.controller;

import com.pcd.ecommerce.model.CartItem;
import com.pcd.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("{id}")
    public CartItem getCartItemById(@PathVariable Long id){
        return this.cartItemService.getCartItemById(id);
    }

    @GetMapping
    public List<CartItem> getAllCartItems(){
        return this.cartItemService.getAllCartItems();
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem){
        return  this.cartItemService.createCartItem(cartItem);
    }

    @PutMapping
    public CartItem updateCartItem(@RequestBody CartItem cartItem){
        return  this.cartItemService.updateCartItem(cartItem);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteById(@PathVariable Long id){
        this.cartItemService.deleteCartItemById(id);
        return HttpStatus.OK;
    }
}
