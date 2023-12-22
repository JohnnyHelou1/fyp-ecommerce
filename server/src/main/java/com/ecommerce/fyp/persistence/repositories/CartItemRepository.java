package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Cart;
import com.ecommerce.fyp.persistence.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
