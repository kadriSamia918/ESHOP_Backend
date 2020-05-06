package com.pcd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name="cartId")
    @JsonIgnore
    private Cart cart;
    private double price;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;


    private int quantity;
    private double total;

}
