package com.memory.Journal.controllers;

import com.memory.Journal.exceptions.ResourceNotFoundException;
import com.memory.Journal.model.User;
import com.memory.Journal.repository.UserRepository;
import com.memory.Journal.userHelper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Optional;

@RestController
@Validated
public class UserController {

    private UserRepository userRepository;

    private UserHelper userHelper;


    @Autowired
    public UserController(UserRepository userRepository, UserHelper userHelper) {
        this.userRepository = userRepository;
        this.userHelper = userHelper;
    }

    //Get user by username
    @GetMapping("/user/{username}")
    public User getUserByUsername(@Valid @PathVariable("username") String username) {
        return userRepository.findByUsername(username).get();
    }

    // get All users
    @RequestMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    // Delete User based on params email and password
    @DeleteMapping("/user")
    public HttpStatus deleteUser(@Email @RequestParam String email, @RequestParam String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty())
            return HttpStatus.INTERNAL_SERVER_ERROR;

        try {
            userRepository.deleteUser(email, password);
            return HttpStatus.OK;
        } catch (IllegalArgumentException iae) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    // update a user; required: email and password
    @PutMapping("/user")
    public User updateUser(@RequestParam String email, @RequestParam String password, @RequestBody User userUpdatedDetails) {
        Optional<User> storedUser = userRepository.findByEmail(email);
        if (storedUser.isPresent() && password != null && storedUser.get().getPassword() != null && storedUser.get().getPassword().equals(password)) {
            userHelper.updateUserDetails(storedUser.get(), userUpdatedDetails);
            userRepository.save(storedUser.get());
            return storedUser.get();
        }
        throw new ResourceNotFoundException(email);
    }
}
