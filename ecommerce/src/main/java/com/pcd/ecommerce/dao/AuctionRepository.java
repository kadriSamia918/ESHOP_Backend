package com.pcd.ecommerce.dao;
import com.pcd.ecommerce.model.Auction;
import com.pcd.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> getAllByBuyer_Id(long id);
}
