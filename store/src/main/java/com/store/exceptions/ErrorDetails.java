package com.store.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ErrorDetails {
	private Date timestamp;
	private String status;
	private String errorMessage;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ErrorDetails(Date timestamp, String status, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessage = errorMessage;
	}
	public ErrorDetails() {}
	
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", status=" + status + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
