package com.egen.ecommerce.ecommerce_order_processing_service.restServices;

import com.egen.ecommerce.ecommerce_order_processing_service.error.handling.ErrorMessageConstants;
import com.egen.ecommerce.ecommerce_order_processing_service.response.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("rawtypes")

public abstract class EcommerceRestService {
	
	@SuppressWarnings("unchecked")
	public ResponseEntity createEntityResponse(Response response){
		ResponseEntity entityResponse;
		if(ErrorMessageConstants.BAD_REQUEST.equals(response.getStatus())){
			entityResponse = new ResponseEntity(response, HttpStatus.BAD_REQUEST);

		} else if(ErrorMessageConstants.NOT_FOUND.equals(response.getStatus())){
			entityResponse = new ResponseEntity(response, HttpStatus.NOT_FOUND);

		} else if(ErrorMessageConstants.TOO_MANY_REQUESTS.equals(response.getStatus())){
			entityResponse = new ResponseEntity(response, HttpStatus.TOO_MANY_REQUESTS);
		}
		else{
			entityResponse = new ResponseEntity(response, HttpStatus.ACCEPTED);
		}
		return entityResponse;
	}

}
