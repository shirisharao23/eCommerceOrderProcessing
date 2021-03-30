package com.egen.ecommerce.ecommerce_order_processing_service.database.models;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Order")
public class Order {
    
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_sequence")
    @SequenceGenerator(name="order_sequence", sequenceName="order_sequence", allocationSize=1)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "number_of_items")
    private Integer numberOfItems;

    @Column(name = "order_subtotal")
    private Float orderSubTotal;

    @Column(name = "order_tax")
    private Float orderTax;

    @Column(name = "order_shipping_charges")
    private Float orderShippingCharges;

    @Column(name = "order_total")
    private Float orderTotal;

    @CreationTimestamp
    @Column(name = "sytem_insertion_ts")
    private OffsetDateTime createdDate;

    @Column(name = "system_revision_ts")
    private OffsetDateTime updatedDate;

    // private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id")
    private Address shippAddress;

    // private List<Payments> paymentInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private String orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_method")
    private String deliveryMethod;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
    
    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OffsetDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }   

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippAddress() {
        return shippAddress;
    }

    public void setShippAddress(Address shippAddress) {
        this.shippAddress = shippAddress;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setOrderSubTotal(Float orderSubTotal) {
        this.orderSubTotal = orderSubTotal;
    }

    public void setOrderTax(Float orderTax) {
        this.orderTax = orderTax;
    }

    public void setOrderShippingCharges(Float orderShippingCharges) {
        this.orderShippingCharges = orderShippingCharges;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

}
