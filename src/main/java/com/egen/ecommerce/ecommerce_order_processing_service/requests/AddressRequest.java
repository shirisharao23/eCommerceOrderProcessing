package com.egen.ecommerce.ecommerce_order_processing_service.requests;

import com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models.RSAddress;

public class AddressRequest {
    private RSAddress rsAddress;

    public RSAddress getRsAddress() {
        return rsAddress;
    }

    public void setRsAddress(RSAddress rsAddress) {
        this.rsAddress = rsAddress;
    }

}
