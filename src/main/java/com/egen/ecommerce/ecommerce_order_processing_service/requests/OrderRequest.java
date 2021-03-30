package com.egen.ecommerce.ecommerce_order_processing_service.requests;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSOrder;

public class OrderRequest extends EcommerceRequest{
    RSOrder order;

    public RSOrder getOrder() {
        return order;
    }

    public void setOrder(RSOrder order) {
        this.order = order;
    }

}
