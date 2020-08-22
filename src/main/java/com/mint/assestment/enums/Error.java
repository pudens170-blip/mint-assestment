package com.mint.assestment.enums;

public enum Error {
	UNVAILABLE("unavailable"),
	INVALID_QUERY_PARAM("Invalid queryparam.Make sure your start is less than your limit and note that start must be greater than 0 ");

	private String value;

	private Error(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	

	
}
