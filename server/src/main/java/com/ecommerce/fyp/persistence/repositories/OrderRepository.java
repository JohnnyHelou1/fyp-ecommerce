package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
