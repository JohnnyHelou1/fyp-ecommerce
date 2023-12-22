package com.ecommerce.fyp.persistence.repositories;

import com.ecommerce.fyp.persistence.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
