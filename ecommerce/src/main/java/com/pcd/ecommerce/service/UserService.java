package com.pcd.ecommerce.service;

import com.pcd.ecommerce.model.User;

import java.util.List;

public interface UserService {

     User createUser( User user);
     User updateUser(User user);
     User getUserById(Long id);
     List<User> getAllUsers();
     void deleteUserById(Long id);

}
