package com.exampleusermgmt.fullstackCrud.controller;

import com.exampleusermgmt.fullstackCrud.exception.UserNotFoundException;
import com.exampleusermgmt.fullstackCrud.model.appUser;
import com.exampleusermgmt.fullstackCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5174/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public appUser newUser(@RequestBody appUser user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public appUser updateUser(@PathVariable Long id, @RequestBody appUser user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setUserName(user.getUserName());
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }else{
            userRepository.deleteById(id);
            return "User deleted id: " + id;
        }
    }

    @GetMapping("/users")
    public List<appUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public appUser getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}


