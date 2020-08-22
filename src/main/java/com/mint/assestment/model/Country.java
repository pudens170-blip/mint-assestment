package com.mint.assestment.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name="num")
	private String numeric;
	@NotNull
	private String alpha2;
	@NotNull
	private String name;
	@NotNull
	private String emoji;
	@NotNull
	private String currency;
	@NotNull
	private int longitude;
	@NotNull
	private int latitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeric() {
		return numeric;
	}

	public void setNumeric(String numeric) {
		this.numeric = numeric;
	}

	public String getAlpha() {
		return alpha2;
	}

	public void setAlpha(String alpha2) {
		this.alpha2 = alpha2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", numeric=" + numeric + ", alpha=" + alpha2 + ", name=" + name + ", emoji="
				+ emoji + ", currency=" + currency + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
