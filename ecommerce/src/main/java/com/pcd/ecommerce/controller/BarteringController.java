package com.pcd.ecommerce.controller;
import com.pcd.ecommerce.model.Bartering;
import com.pcd.ecommerce.service.BarteringService;
import com.pcd.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/bartering")
public class BarteringController {
    @Autowired
    private BarteringService barteringService;



    @GetMapping("{id}")
    public Bartering getBarteringById(@PathVariable Long id){return this.barteringService.getBarteringById(id);}

    @GetMapping
    public List<Bartering> getAllBartering() {return this.barteringService.getAllBartering();}

    @PostMapping
    public Bartering createBartering( @RequestBody Bartering bartering)  { return this.barteringService.createBartering(bartering); }

    @PutMapping
    public  Bartering updateBartering(@RequestBody Bartering bartering){return this.barteringService.updateBartering(bartering);}

    @DeleteMapping("{id}")
    public HttpStatus deleteBarteringById(@PathVariable Long id){
        this.barteringService.deleteBarteringById(id);
         return HttpStatus.OK; }


    @PutMapping("/bartering/image/{id}")
    public  Bartering uploadBartering(@PathVariable long id,@RequestParam("myFile") MultipartFile image) throws IOException
    {
        return this.barteringService.uploadBartering(id, image);
    }

   @GetMapping("/bartering/user/{id}")
    public ResponseEntity<List<Bartering>> getAllBySourceUser(@PathVariable long id) {
        return ResponseEntity.ok().body(this.barteringService.getAllBySourceUser(id));
    }

    @GetMapping("/bartering/switch/{user1}/{product1}/{user2}/{product2}")
    public void switchOwners(@PathVariable long user1,@PathVariable long product1,@PathVariable long user2,@PathVariable long product2){
         this.barteringService.switchOwners(user1,product1,user2,product2);
    }





}
