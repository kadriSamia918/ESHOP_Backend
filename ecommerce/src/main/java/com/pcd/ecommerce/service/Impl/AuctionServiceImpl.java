package com.pcd.ecommerce.service.Impl;
import com.pcd.ecommerce.dao.AuctionRepository;
import com.pcd.ecommerce.model.Auction;
import com.pcd.ecommerce.model.Product;
import com.pcd.ecommerce.model.User;
import com.pcd.ecommerce.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Auction createAuction(Auction auction){return this.auctionRepository.save(auction);}
    @Override
    public  Auction updateAuction(Auction auction){ return this.auctionRepository.save(auction);}
    @Override
    public List<Auction> getAllAuction(){return this.auctionRepository.findAll();}
    @Override
    public Auction getAuctionById(Long id) {return this.auctionRepository.findById(id).get();}
    @Override
    public void deleteAuctionById(Long id) {
        this.auctionRepository.deleteById(id);
    }


    @Override
    public Auction updateBid(long auctionId, long buyerId, double price){
        Auction auctionDb = this.auctionRepository.findById(auctionId).get();
        User buyer = new User();
        buyer.setId(buyerId);
        auctionDb.setBuyer(buyer);
        auctionDb.setCurrentPrice(price);
        return this.auctionRepository.save(auctionDb);
    }

    @Override
    public Auction uploadAuction(long id, MultipartFile image) throws IOException {
        Optional<Auction> auctionDb = auctionRepository.findById(id);
        if (auctionDb.isPresent()) {
            System.out.println("image bytes....."+image.getBytes());
            Auction auctionUpload = auctionDb.get();
            auctionUpload.setAuctionImage(image.getBytes());

            return auctionRepository.save(auctionUpload);
        }
        else {
            throw new IOException("cannot upload image");
             }
    }


    @Override
    public List<Auction> getAllByBuyer(long id){
        return this.auctionRepository.getAllByBuyer_Id(id);

    }


}
