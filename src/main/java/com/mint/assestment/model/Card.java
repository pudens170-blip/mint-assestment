package com.mint.assestment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import com.mint.assestment.enums.Scheme;
import com.mint.assestment.enums.Type;

@Entity
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "bin")
	@NotNull
	private String bankVerificationNumber;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Scheme scheme;
	@NotNull
	private Type type;
	private boolean isPrepaid;
	@NotNull
	private String brand;

	public long getId() {
		return id;
	}

	@OneToOne
	@JoinColumn(name = "bank_fk")
	private Bank bank;

	@OneToOne
	@JoinColumn(name = "country_fk")
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isPrepaid() {
		return isPrepaid;
	}

	public void setPrepaid(boolean isPrepaid) {
		this.isPrepaid = isPrepaid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getBankVerificationNumber() {
		return bankVerificationNumber;
	}

	public void setBankVerificationNumber(String bankVerificationNumber) {
		this.bankVerificationNumber = bankVerificationNumber;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", scheme=" + scheme + ", type=" + type + ", isPrepaid=" + isPrepaid + ", brand="
				+ brand + ", bank=" + bank + "]";
	}

}
