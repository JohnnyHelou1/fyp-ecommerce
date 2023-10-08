package com.ecommerce.fyp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(value = "/index")
    public List<Product> getAllProducts() {
        return "hello";
    }

    @PostMapping
    public void addProduct(Product product) {
        // add to repository
    }

    @PostMapping(value = "/bla")
    public void add() {

    }
}
