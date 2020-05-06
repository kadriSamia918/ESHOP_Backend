package com.pcd.ecommerce.service;

import com.pcd.ecommerce.model.Cart;

import java.util.List;

public interface CartService {

    Cart createCart(Cart cart);
    Cart updateCart(Cart cart);
    List<Cart> getAllCarts();
    Cart getCartById(Long id);
    void deleteById(Long id);
}
