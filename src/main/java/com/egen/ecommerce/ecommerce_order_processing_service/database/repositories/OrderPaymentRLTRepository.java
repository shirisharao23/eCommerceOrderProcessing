package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.OrderPaymentRLT;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentRLTRepository extends JpaRepository<OrderPaymentRLT, Long>{
    
}
