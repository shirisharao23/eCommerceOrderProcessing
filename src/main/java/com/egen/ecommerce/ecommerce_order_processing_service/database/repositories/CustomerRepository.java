package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);
}
