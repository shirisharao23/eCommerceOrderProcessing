package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByProductId(Integer productId);
}
