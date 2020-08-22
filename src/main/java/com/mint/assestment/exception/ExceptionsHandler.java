package com.mint.assestment.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mint.assestment.pojo.ApplicationResponse;

@ControllerAdvice
public class ExceptionsHandler {
	static Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

	@Autowired
	private ApplicationResponse response;

	@ExceptionHandler
	public ResponseEntity<ApplicationResponse> handleException(InvalidParameterException e) {
		response.setMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
