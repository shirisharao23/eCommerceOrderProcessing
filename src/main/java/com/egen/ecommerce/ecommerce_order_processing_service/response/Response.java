package com.egen.ecommerce.ecommerce_order_processing_service.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"message"})    
public class Response extends EcommerceCommonResponse {
	private String message = null;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
}


