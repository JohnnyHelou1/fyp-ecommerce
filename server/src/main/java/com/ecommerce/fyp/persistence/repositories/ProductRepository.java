package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Product;
import com.ecommerce.fyp.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}