package com.ecommerce.fyp.controllers;

import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.services.InventoryService;
import com.ecommerce.fyp.services.exceptions.InsufficientQuantityException;
import com.ecommerce.fyp.services.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ecommerce/products")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(value = "/{id}/inventory/{quantity}")
    public void createOrUpdateQuantity (@PathVariable("id") int productId, @PathVariable("quantity") int quantity) throws ProductNotFoundException, InsufficientQuantityException {
        inventoryService.createOrUpdateQuantity(productId, quantity);
    }
}
