package com.egen.ecommerce.ecommerce_order_processing_service.database.models;

import java.time.OffsetDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_payment_rlt")
public class OrderPaymentRLT {
    
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_payment_rlt_sequence")
    @SequenceGenerator(name="order_payment_rlt_sequence", sequenceName="order_payment_rlt_sequence", allocationSize=1)
    @Column(name = "id")
    private Integer orderPaymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")    
    private Payment payment;

    @CreationTimestamp
    @Column(name = "sytem_insertion_ts", updatable = false)
    private OffsetDateTime createdDateTime;

    @UpdateTimestamp
    @Column(name = "system_revision_ts", updatable = false)
    private OffsetDateTime updatedDateTime;

    public Integer getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(Integer orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }  

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public OffsetDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(OffsetDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
