package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.InvoiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceOrderRepository extends JpaRepository<InvoiceOrder, Integer> {
}
