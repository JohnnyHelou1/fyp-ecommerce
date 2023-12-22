package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Inventory;
import com.ecommerce.fyp.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByProduct(Product product);
}
