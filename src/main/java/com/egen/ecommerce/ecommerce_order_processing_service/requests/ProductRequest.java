package com.egen.ecommerce.ecommerce_order_processing_service.requests;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSProduct;

public class ProductRequest {
    
    private RSProduct rsProduct;

    public RSProduct getRsProduct() {
        return rsProduct;
    }

    public void setRsProduct(RSProduct rsProduct) {
        this.rsProduct = rsProduct;
    }
}
