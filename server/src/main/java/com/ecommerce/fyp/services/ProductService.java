package com.ecommerce.fyp.services;

import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.model.User;
import com.ecommerce.fyp.persistence.repositories.ProductRepository;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import com.ecommerce.fyp.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public List<Product> getAll() {
        return repository.findAll();
    }
    public Product getProduct(int id) throws ProductNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    public Product createProduct(Product product) {
        return repository.saveAndFlush(product);
    }
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}