package com.egen.ecommerce.ecommerce_order_processing_service.database.repositories;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByAddressLine1AndCity(String addressLine1, String City);
}
