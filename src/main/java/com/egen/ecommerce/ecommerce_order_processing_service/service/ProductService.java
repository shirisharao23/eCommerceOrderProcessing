package com.egen.ecommerce.ecommerce_order_processing_service.service;

import javax.transaction.Transactional;

import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Order;
import com.egen.ecommerce.ecommerce_order_processing_service.database.models.Product;
import com.egen.ecommerce.ecommerce_order_processing_service.database.repositories.ProductRepository;
import com.egen.ecommerce.ecommerce_order_processing_service.response.ProductResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    RestTemplateHelper restTemplateHelper;

    @Autowired
    ProductRepository productRepo;

    private final Logger classLogger = LoggerFactory.getLogger(ProductService.class);

    public Product saveItem(ProductResponse itemRes, Order order) {
		classLogger.info("Initiating Item Save Request");
		Product item = new Product();		
		item.setProductName(itemRes.getRsProduct().getItemName());
		item.setProductPrice(itemRes.getRsProduct().getItemPrice());
		item.setStock(itemRes.getRsProduct().getItemQuantity());
		item.setProductDescription(itemRes.getRsProduct().getProductDescription());		
		return productRepo.save(item);
	}

	
}
