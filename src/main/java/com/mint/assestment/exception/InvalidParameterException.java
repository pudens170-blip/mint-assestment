package com.mint.assestment.exception;

public class InvalidParameterException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String message;

	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
