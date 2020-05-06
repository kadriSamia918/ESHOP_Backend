package com.pcd.ecommerce.controller;

import com.pcd.ecommerce.model.User;
import com.pcd.ecommerce.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        // you can return model User or return ResponseEntity: see productController.
        return this.userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public  User getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user){
//
        logger.trace("getting user from postman");
        logger.trace("user: ",user);
        return  this.userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable Long id){
        this.userService.deleteUserById(id);
        return HttpStatus.OK;
    }



}
