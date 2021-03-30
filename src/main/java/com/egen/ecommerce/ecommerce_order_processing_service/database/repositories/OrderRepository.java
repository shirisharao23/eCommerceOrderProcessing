package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import java.time.OffsetDateTime;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Address;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Customer;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends  JpaRepository<Order, Long> {
    Order findByOrderId(Long orderId);
    Order findByShippngAddressAndCreatedDate(Address shippAddress, OffsetDateTime createdDate);
}
