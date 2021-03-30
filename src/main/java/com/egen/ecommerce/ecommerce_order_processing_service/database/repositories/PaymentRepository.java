package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
