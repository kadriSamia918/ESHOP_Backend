package com.pcd.ecommerce.controller;

import com.pcd.ecommerce.dao.CartItemRepository;
import com.pcd.ecommerce.dao.CartRepository;
import com.pcd.ecommerce.dao.ProductRepository;
import com.pcd.ecommerce.dao.UserRepository;
import com.pcd.ecommerce.model.Cart;
import com.pcd.ecommerce.model.CartItem;
import com.pcd.ecommerce.model.Product;
import com.pcd.ecommerce.model.User;
import com.pcd.ecommerce.service.CartItemService;
import com.pcd.ecommerce.service.CartService;
import com.pcd.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts(){
        return this.cartService.getAllCarts();
    }
    @GetMapping("{id}")
    public Cart getCartById(@PathVariable Long id){
        return  this.cartService.getCartById(id);
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart){
        return this.cartService.createCart(cart);
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart){
        return this.cartService.updateCart(cart);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteCart(@PathVariable Long id){
        this.cartService.deleteById(id);
        return HttpStatus.OK;
    }
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository clientRepository;
    @Autowired
    private CartRepository orderRepository;
    @Autowired
    private CartItemRepository orderItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CartItemService cartItemService;
    @PostMapping("/orders")
    public ResponseEntity< Cart > saveOrder(@RequestBody OrderForm orderForm){
        User client=new User();
        client.setFirstName(orderForm.getClient().getFirstName());
        client.setEmail(orderForm.getClient().getEmail());
        client.setPhone(orderForm.getClient().getPhone());
        client.setUserName(orderForm.getClient().getUserName());
        ResponseEntity.ok().body(this.userService.createUser(client));
        Cart order=new Cart();
        order.setUser(client);

        ResponseEntity.ok().body(this.cartService.createCart(order));
        double total=0;
        for(OrderProduct p:orderForm.getProducts()){
            CartItem orderItem=new CartItem();
            Product product=productRepository.findById(p.getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(p.getQuantity());
            ResponseEntity.ok().body(this.cartItemService.createCartItem(orderItem));
            total+=p.getQuantity()*product.getPrice();
        }
        order.setgrandTotal(total);
      return ResponseEntity.ok().body(this.cartService.createCart(order));

    }
}
