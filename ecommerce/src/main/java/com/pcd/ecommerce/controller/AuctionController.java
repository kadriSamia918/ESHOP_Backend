package com.pcd.ecommerce.controller;
import com.pcd.ecommerce.model.Auction;
import com.pcd.ecommerce.model.Product;
import com.pcd.ecommerce.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auction")

public class AuctionController {

    @Autowired
    private AuctionService auctionService;
    @GetMapping
    public List<Auction> getAllAuction(){ return this.auctionService.getAllAuction();}
    @GetMapping("{id}")
    public Auction getAuctionById(@PathVariable Long id){return this.auctionService.getAuctionById(id);}
    @PostMapping
    public Auction createAuction(@RequestBody Auction auction){ return this.auctionService.createAuction(auction);}
    @PutMapping
    public Auction updateAuction(@RequestBody Auction auction){ return this.auctionService.updateAuction(auction);}
    @DeleteMapping("{id}")
    public HttpStatus deleteAuctionById(@PathVariable Long id){
        this.auctionService.deleteAuctionById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/auctions/image/{id}")
    public Auction uploadAuction(@PathVariable long id, @RequestParam("myFile") MultipartFile image) throws IOException {
        return  this.auctionService.uploadAuction(id, image);
    }


   @GetMapping("/bid/{auctionId}/{buyerId}/{price}")
   public Auction updateBid(@PathVariable long auctionId, @PathVariable long buyerId, @PathVariable double price){
       return this.auctionService.updateBid(auctionId,buyerId,price);
   }

   @GetMapping("/auction/user/{id}")
   public ResponseEntity<List<Auction>> getAllByBuyer(@PathVariable long id){
       return  ResponseEntity.ok().body(this.auctionService.getAllByBuyer(id));

   }



}
