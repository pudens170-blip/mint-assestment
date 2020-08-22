package com.mint.assestment.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Scheme {

	@JsonProperty("visa")
	VISA("visa"), @JsonProperty("mastercard")
	MASTER_CARD("mastercard"), @JsonProperty("amex")
	AMEX("amex");

	private String value;

	private Scheme(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
