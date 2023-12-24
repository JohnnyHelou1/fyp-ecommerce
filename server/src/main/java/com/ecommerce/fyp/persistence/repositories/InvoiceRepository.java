package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
