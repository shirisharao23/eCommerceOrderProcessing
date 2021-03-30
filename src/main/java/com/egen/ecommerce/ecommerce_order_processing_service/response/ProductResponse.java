package com.egen.ecommerce.ecommerce_order_processing_service.response;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSProduct;

public class ProductResponse extends Response{
    
    private RSProduct rsProduct;

    public RSProduct getRsProduct() {
        return rsProduct;
    }

    public void setRsProduct(RSProduct rsProduct) {
        this.rsProduct = rsProduct;
    }


}
