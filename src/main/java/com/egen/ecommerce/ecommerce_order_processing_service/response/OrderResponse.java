package com.egen.ecommerce.ecommerce_order_processing_service.response;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSOrder;

public class OrderResponse extends Response{

    private RSOrder order;

    public RSOrder getOrder() {
        return order;
    }

    public void setOrder(RSOrder order) {
        this.order = order;
    }
    
}
