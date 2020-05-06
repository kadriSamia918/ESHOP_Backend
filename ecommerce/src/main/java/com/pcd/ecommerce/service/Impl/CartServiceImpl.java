package com.pcd.ecommerce.service.Impl;

import com.pcd.ecommerce.dao.CartRepository;
import com.pcd.ecommerce.model.Cart;
import com.pcd.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllCarts() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long id) {
        return this.cartRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        this.cartRepository.deleteById(id);

    }
}
