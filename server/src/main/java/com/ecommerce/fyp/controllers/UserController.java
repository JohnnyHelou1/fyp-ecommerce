package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.persistence.model.User;
import com.ecommerce.fyp.persistence.repositories.UserRepository;
import com.ecommerce.fyp.services.UserService;
import com.ecommerce.fyp.services.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ecommerce/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return new ArrayList<>(userService.getAll());
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @PutMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}
