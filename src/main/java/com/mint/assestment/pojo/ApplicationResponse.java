package com.mint.assestment.pojo;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;
	

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public ApplicationResponse() {
	}

	public void setSuccessResponse(String message) {
		this.message = message;
		this.timestamp = LocalDateTime.now();
		this.status = HttpStatus.OK.value();
	}

	public void setErrorResponse(String message) {
		this.message = message;
		this.timestamp = LocalDateTime.now();
		this.status = HttpStatus.BAD_REQUEST.value();
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	
	

}
