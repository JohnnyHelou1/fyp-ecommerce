package com.ecommerce.fyp.services;

import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.model.ProductImage;
import com.ecommerce.fyp.persistence.repositories.ProductImageRepository;
import com.ecommerce.fyp.persistence.repositories.ProductRepository;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductImageRepository imageRepository;

    @Autowired
    public ProductService(ProductRepository repository, ProductImageRepository imageRepository) {
        this.repository = repository;
        this.imageRepository = imageRepository;
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

    public ProductImage createImage(ProductImage image) {
        return imageRepository.saveAndFlush(image);
    }

    public void deleteImage(int id) {

        imageRepository.deleteById(id);
    }
}