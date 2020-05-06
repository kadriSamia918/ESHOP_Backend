package com.pcd.ecommerce.controller;

import com.pcd.ecommerce.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class OrderForm {
    private User client=new User();
    private List<OrderProduct> products=new ArrayList<>();
}
@Data
class OrderProduct{
    private Long id;
    private int quantity;

}