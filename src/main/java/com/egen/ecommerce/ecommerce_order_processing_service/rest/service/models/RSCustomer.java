package com.egen.ecommerce.ecommerce_order_processing_service.rest.service.models;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RSCustomer extends EcommerceOrderServiceModel{

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("middlename")
    private String middleName;

    @JsonProperty("emailid")
    private String emailId;

    @JsonProperty("phonenumber")
    private String phoneNumber;

    @JsonProperty("birthDate")
    private OffsetDateTime birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.[SSS][SSSSSS]x")	
    @JsonProperty("created_dt")
    private OffsetDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.[SSS][SSSSSS]x")	
    @JsonProperty("updated_dt")
    private OffsetDateTime updateDate;

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public OffsetDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(OffsetDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    
    
}
