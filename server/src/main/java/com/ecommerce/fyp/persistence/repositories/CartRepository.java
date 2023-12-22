package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
