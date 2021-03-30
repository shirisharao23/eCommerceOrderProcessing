package com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class RSOrder extends EcommerceOrderServiceModel {
    
   
    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("customer")
    private RSCustomer rsCustomer;

    @JsonProperty("billing_address")
    private RSAddress billingAddress;

    @JsonProperty("shipping_address")
    private RSAddress shippingAddress;
   
    @JsonProperty("items")
    private List<RSProduct> rsItem;  

    @JsonProperty("number_of_items")
    private Integer numberOfItems;

    @JsonProperty("order_subtotal")
    private float subtotal;

    @JsonProperty("order_tax")
    private float orderTax;

    @JsonProperty("shipping_charges")
    private float shippingCharges;

    @JsonProperty("order_total")
    private float orderTotal;

    @JsonProperty("payment_information")
    private List<RSPayment> rsPayments; 

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("delivery_method")
    private String deliveryMethod;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public RSCustomer getRsCustomer() {
        return rsCustomer;
    }

    public void setRsCustomer(RSCustomer rsCustomer) {
        this.rsCustomer = rsCustomer;
    }  
    
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(float orderTax) {
        this.orderTax = orderTax;
    }

    public float getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(float shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<RSProduct> getRsItem() {
        return rsItem;
    }

    public void setRsItem(List<RSProduct> rsItem) {
        this.rsItem = rsItem;
    }   

    public List<RSPayment> getRsPayments() {
        return rsPayments;
    }

    public void setRsPayments(List<RSPayment> rsPayments) {
        this.rsPayments = rsPayments;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public RSAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(RSAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public RSAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(RSAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
