package com.ecommerce.fyp.services;

import com.ecommerce.fyp.persistence.model.Inventory;
import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.repositories.InventoryRepository;
import com.ecommerce.fyp.persistence.repositories.ProductRepository;
import com.ecommerce.fyp.services.exceptions.InsufficientQuantityException;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository repository;
    private final ProductRepository productRepository;

    @Autowired
    public InventoryService(InventoryRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public void createOrUpdateQuantity(int productId, int quantity) throws ProductNotFoundException, InsufficientQuantityException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        Optional<Inventory> optionalInventory = repository.findByProduct(product);
        if (optionalInventory.isEmpty()) {
            if (quantity >= 0) {
                Inventory inventory = new Inventory(quantity, product);
                repository.saveAndFlush(inventory);
            } else {
                throw new InsufficientQuantityException(quantity);
            }
        } else {
            Inventory inventory = optionalInventory.get();
            if (quantity >= 0) {
                inventory.setQuantity(inventory.getQuantity() + quantity);
                repository.saveAndFlush(inventory);
            } else {
                if (inventory.getQuantity() + quantity < 0) {
                    throw new InsufficientQuantityException(quantity);
                } else {
                    inventory.setQuantity(inventory.getQuantity() + quantity);
                    repository.saveAndFlush(inventory);
                }
            }
        }
    }
}