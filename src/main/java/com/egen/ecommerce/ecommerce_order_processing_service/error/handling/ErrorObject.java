package com.egen.ecommerce.ecommerce_order_processing_service.error.handling;

public class ErrorObject {
    
    String errorMessage;
	String errorCode;
	String severity;
	String detailedErrorMessage;
	String stackTrace;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDetailedErrorMessage() {
		return detailedErrorMessage;
	}
	public void setDetailedErrorMessage(String detailedErrorMessage) {
		this.detailedErrorMessage = detailedErrorMessage;
	}
	public String getStackTrace() {
		return stackTrace;
	}
	public void appendStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	@Override
	public String toString() {
		StringBuilder errorString = new StringBuilder();
		errorString.append("Error Message: ");
		errorString.append(this.errorMessage);
		errorString.append("\n");
		errorString.append("Error Code: ");
		errorString.append(this.errorCode);
		errorString.append("\n");
		errorString.append("Severity: ");
		errorString.append(this.severity);
		errorString.append("\n");
		errorString.append("Detailed Error Message: ");
		errorString.append(this.detailedErrorMessage);
		errorString.append("\n");
		errorString.append("Stacktrace: ");
		errorString.append(this.stackTrace);
		
		return errorString.toString();
	}
}
