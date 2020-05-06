package com.pcd.ecommerce.service.Impl;

import com.pcd.ecommerce.dao.CartItemRepository;
import com.pcd.ecommerce.model.CartItem;
import com.pcd.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem){
        return this.cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return this.cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getCartItemById(Long id) {
        return this.cartItemRepository.findById(id).get();
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return this.cartItemRepository.findAll();
    }

    @Override
    public void deleteCartItemById(Long id) {
        this.cartItemRepository.deleteById(id);
    }
}
