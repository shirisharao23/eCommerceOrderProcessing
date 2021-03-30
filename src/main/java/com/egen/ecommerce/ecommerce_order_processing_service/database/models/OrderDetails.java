package com.egen.ecommerce.ecommerce_order_processing_service.database.models;

import java.time.OffsetDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_details_sequence")
    @SequenceGenerator(name = "order_details_sequence", sequenceName = "order_details_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer orderDetailsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Product item;

    @Column(name = "item_qty")
    private Integer itemOrdered;

    @Column(name = "item_price")
    private Integer itemPrice;

    @Column(name = "item_name")
    private Integer itemName;

    @CreationTimestamp
	@Column(name = "sytem_insertion_ts", updatable = false)
	private OffsetDateTime createdTimestamp;

    @UpdateTimestamp
	@Column(name = "sytem_revision_ts")
	private OffsetDateTime updatedTimestamp;

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public Integer getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(Integer itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemName() {
        return itemName;
    }

    public void setItemName(Integer itemName) {
        this.itemName = itemName;
    }

    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public OffsetDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(OffsetDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

}
