package com.egen.ecommerce.ecommerce_order_processing_service.restServices;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Order;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.OrderRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
public class EcommerceOrderProcessingServices {

    @Autowired
    OrderRepository orderRepo;
    @Autowired
    ProductRepository productRepo;

    private final Logger classLogger = LoggerFactory.getLogger(EcommerceOrderProcessingServices.class);
    
    @GetMapping("/{order_id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepo.findByOrderId(id);
        classLogger.info("Order");	
		return order == null ? ResponseEntity.notFound().build()
				: ResponseEntity.ok(order);		
    }

    


}

