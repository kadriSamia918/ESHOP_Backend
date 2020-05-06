package com.pcd.ecommerce.service;

import com.pcd.ecommerce.model.CartItem;

import java.util.List;

public interface CartItemService {

    CartItem createCartItem(CartItem cartItem);
    CartItem updateCartItem(CartItem cartItem);
    CartItem getCartItemById(Long id);
    List<CartItem> getAllCartItems();
    void deleteCartItemById(Long id);
}
