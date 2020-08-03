package com.tjib.app.entities;

import javax.persistence.*;

@Entity
public class Shipping {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String country;
	private String city;
	private String street;
	private int houseNum;
	private int zipCode;
	private int creditCard;
	private int creditExpiration;
	
	public Shipping() {}
	
	public Shipping(String firstName, String lastName, String country, String city, String street,
			int houseNum, int zipCode, int creditCard, int creditExpiration) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.city = city;
		this.street = street;
		this.houseNum = houseNum;
		this.zipCode = zipCode;
		this.creditCard = creditCard;
		this.creditExpiration = creditExpiration;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public int getCreditExpiration() {
		return creditExpiration;
	}

	public void setCreditExpiration(int creditExpiration) {
		this.creditExpiration = creditExpiration;
	}
	
	

}
