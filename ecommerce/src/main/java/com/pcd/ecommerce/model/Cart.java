package com.pcd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name="customerId")
    @JsonIgnore
    private User user;

    private double grandTotal;
    @OneToOne
    private payment payment;

    public void setgrandTotal(double total) {
        this.grandTotal=total;

    }
}
