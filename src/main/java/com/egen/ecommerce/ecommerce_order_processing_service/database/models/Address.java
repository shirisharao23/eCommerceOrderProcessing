package com.egen.ecommerce.ecommerce_order_processing_service.database.models;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Address")
public class Address {
    
    @Id@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_sequence")
    @SequenceGenerator(name="address_sequence", sequenceName="address_sequence", allocationSize=1)
    @Column(name = "id")
    private Integer addressId;

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
	private String addressType;

	@Column(name = "address_usage_type")
	private String usageType;
	
	@Column(name = "address")
	private String addressLine1;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private String zipcode;	
	
	@CreationTimestamp
	@Column(name = "sytem_insertion_ts", updatable = false)
	private OffsetDateTime createdTimestamp;

    @UpdateTimestamp
	@Column(name = "sytem_revision_ts")
	private OffsetDateTime updatedTimestamp;
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
	private List<Order> order_address;    

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
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

    public List<Order> getOrder_address() {
        return order_address;
    }

    public void setOrder_address(List<Order> order_address) {
        this.order_address = order_address;
    }
   

    
	
}
