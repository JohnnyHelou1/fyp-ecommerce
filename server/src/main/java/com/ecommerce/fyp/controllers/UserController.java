package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.persistence.model.User;
import com.ecommerce.fyp.persistence.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ecommerce/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return new ArrayList<>(userRepository.findAll());
    }
}
