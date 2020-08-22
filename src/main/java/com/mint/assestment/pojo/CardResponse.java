package com.mint.assestment.pojo;

import org.springframework.stereotype.Component;

@Component
public class CardResponse {
private boolean success;
private CardPojo payload;

public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public CardPojo getPayload() {
	return payload;
}
public void setPayload(CardPojo payload) {
	this.payload = payload;
}

	
}
