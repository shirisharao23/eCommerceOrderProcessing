package com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RSProduct extends EcommerceOrderServiceModel {

    @JsonProperty("item_id")
    private Integer itemId;
    
    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("item_qty")
    private Integer itemQuantity;

    @JsonProperty("item_price")
    private Integer itemPrice;

    @JsonProperty("product_description")
    private String productDescription;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

}
