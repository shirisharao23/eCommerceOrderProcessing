package com.egen.ecommerce.ecommerce_order_processing_service.response;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSPayment;

public class PaymentResponse extends Response{
    
    private RSPayment rsPayment;

    public RSPayment getRsPayment() {
        return rsPayment;
    }

    public void setRsPayment(RSPayment rsPayment) {
        this.rsPayment = rsPayment;
    }

}
