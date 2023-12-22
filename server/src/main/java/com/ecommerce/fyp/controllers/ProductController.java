package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.services.ProductService;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ecommerce/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return new ArrayList<>(productService.getAll());
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable ("id") int id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

    @PutMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }
}



