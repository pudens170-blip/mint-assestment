package com.mint.assestment.pojo;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CardStatisticsResponse {
	private boolean success;
	private int start;
	private int limit;
	private long size;
	private Map<String, Long> payload;
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public long getSize() {
		return size;
	}

	public Map<String, Long> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Long> payload) {
		this.payload = payload;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
