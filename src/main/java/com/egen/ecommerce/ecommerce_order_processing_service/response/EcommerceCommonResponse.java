package com.egen.ecommerce.ecommerce_order_processing_service.response;

import java.util.ArrayList;

import com.egen.ecommerce.ecommerce_order_processing_service.error.handling.ErrorObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.http.HttpStatus;

public class EcommerceCommonResponse {

    private String status;
	private HttpStatus statusCode;

	@JsonInclude(Include.NON_EMPTY)
	private ArrayList<ErrorObject> errors = new ArrayList<ErrorObject>();
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	
	
	public ArrayList<ErrorObject> getErrors() {
		if(errors == null) {
			new ArrayList<ErrorObject>();
		}
		return errors;
	}
	public void setErrors(ArrayList<ErrorObject> errors) {
		this.errors = errors;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(ErrorObject error: errors) {
			sb.append(error.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	public void addError(String errorCode, String severity, String errorMessage, String detailedMessage, String stacktrace) {
		ErrorObject error = new ErrorObject();
		error.setErrorCode(errorCode);
		error.setSeverity(severity);
		error.setErrorMessage(errorMessage);
		error.setDetailedErrorMessage(detailedMessage);
		error.appendStackTrace(stacktrace);
		if(this.errors.isEmpty()){
			this.errors = new ArrayList<ErrorObject>();
		}
		ArrayList<ErrorObject> errors = this.getErrors();
		errors.add(error);
		this.setErrors(errors);
	}
	
}
