package com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RSAddress extends EcommerceOrderServiceModel {

    @JsonProperty("address_type")
    private String addressType;

    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("addressLine2")
    private String addressLine2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("isShippingSameAsBilling")
    private boolean isShippingSameAsBilling;

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isShippingSameAsBilling() {
        return isShippingSameAsBilling;
    }

    public void setShippingSameAsBilling(boolean isShippingSameAsBilling) {
        this.isShippingSameAsBilling = isShippingSameAsBilling;
    }
    
}
