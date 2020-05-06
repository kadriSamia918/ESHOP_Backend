package com.pcd.ecommerce.controller;

import com.pcd.ecommerce.model.Product;
import com.pcd.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService productService;
    Logger logger = LoggerFactory.getLogger(productController.class);
    @GetMapping("/")
    public String hello(){

        logger.info("prodcut controller");
        return "Welcome to the demo product application";
    }

    @GetMapping("/products")

    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity < Product > getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity < Product > createProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(this.productService.createProduct(product));

    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }

    @GetMapping("/products/user/{id}")
    public ResponseEntity<List<Product>> getAllByUserId(@PathVariable long id){
        return  ResponseEntity.ok().body(this.productService.getAllByUserId(id));

    }


    @PutMapping("/products/image/{id}")
    public Product uploadImage(@PathVariable long id, @RequestParam("myFile") MultipartFile image) throws IOException {
        return  this.productService.uploadImage(id, image);
    }


}
