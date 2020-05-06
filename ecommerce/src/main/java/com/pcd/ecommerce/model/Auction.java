package com.pcd.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
@Data
@Entity
@Table(name="auction")

public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private double CurrentPrice;

    private double StartingPrice;

    private String Description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date PostedDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date EndingDate;


    @ManyToOne(optional = false)
    @JoinColumn(name ="seller_id")
    private User seller;


    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="buyer_id")
    private User buyer;


    @ManyToOne(optional = false)
    @JoinColumn(name ="product_id")
    private Product product;

    @Lob
    private byte[] auctionImage;
}

