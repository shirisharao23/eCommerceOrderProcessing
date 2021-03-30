package com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RSPayment extends EcommerceOrderServiceModel{

    @JsonProperty("split_payment")
    private boolean splitPayment;

    @JsonProperty("amount")
    private Float amount;

    @JsonProperty("number_of_payment_methods")
    private Integer numberOfPaymentMethods;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("cv")
    private String cvv;

    @JsonProperty("cardholder_name")
    private String cardholderName;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("expiry_date")
    private String expiryDate;

    public boolean isSplitPayment() {
        return splitPayment;
    }

    public void setSplitPayment(boolean splitPayment) {
        this.splitPayment = splitPayment;
    }

    public Integer getNumberOfPaymentMethods() {
        return numberOfPaymentMethods;
    }

    public void setNumberOfPaymentMethods(Integer numberOfPaymentMethods) {
        this.numberOfPaymentMethods = numberOfPaymentMethods;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }



    
}
