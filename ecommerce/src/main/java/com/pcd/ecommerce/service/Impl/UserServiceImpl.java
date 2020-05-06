package com.pcd.ecommerce.service.Impl;

import com.pcd.ecommerce.dao.UserRepository;
import com.pcd.ecommerce.exceptions.ResourceNotFoundException;
import com.pcd.ecommerce.model.User;
import com.pcd.ecommerce.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {

        // Extract user from database.
        Optional<User> userDb = this.userRepository.findById(user.getId());

        //verify if user is in the database.
        if (userDb.isPresent()) {
            //if so update
            return this.userRepository.save(user);
        } else {
            //else throw an exception.
            throw new ResourceNotFoundException("Record not found with id: " + user.getId());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).get();  // because findByid returns optional.
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

}



