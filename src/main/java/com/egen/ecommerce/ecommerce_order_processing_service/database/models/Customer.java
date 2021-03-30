package com.egen.ecommerce.ecommerce_order_processing_service.database.models;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Customer")
public class Customer {
    
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_sequence")
    @SequenceGenerator(name="customer_sequence", sequenceName="customer_sequence", allocationSize=1)
    @Column(name = "id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "emailid")
    private String emailId;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "phone_extension")
	private String phoneNumberExtension;

    @Column(name = "birthdate")
    private String birthDate;

    @Column(name = "gender")
    private String gender;

    @CreationTimestamp
	@Column(name = "system_insert_ts", updatable = false)
	private OffsetDateTime createdTimestamp;

    @UpdateTimestamp
	@Column(name = "sytem_revision_ts")
	private OffsetDateTime updatedTimestamp;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Order> orders;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumberExtension() {
        return phoneNumberExtension;
    }

    public void setPhoneNumberExtension(String phoneNumberExtension) {
        this.phoneNumberExtension = phoneNumberExtension;
    }

    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OffsetDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(OffsetDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
