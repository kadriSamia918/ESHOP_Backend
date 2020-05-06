package com.pcd.ecommerce.dao;

import com.pcd.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByUser_Id(long id);
}
