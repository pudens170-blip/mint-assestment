package com.mint.assestment.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {

	@JsonProperty("debit")
	DEBIT("debit"),

	@JsonProperty("credit")
	CREDIT("credit");

	private String value;

	private Type(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
