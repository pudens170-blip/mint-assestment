package com.mint.assestment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Column(name = "bin")
	private String bankIdentificationNumber;
	private long count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBankVerificationNumber() {
		return bankIdentificationNumber;
	}

	public void setBankVerificationNumber(String bankIdentificationNumber) {
		this.bankIdentificationNumber = bankIdentificationNumber;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
