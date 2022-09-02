package com.bosch.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Addresses {

	@ApiModelProperty(value = "adresses_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adresses_id;
	
	@ApiModelProperty(value = "Apartmente Number/Name")
    @Column(nullable = true)
	String apartment;
	
	@ApiModelProperty(value = "Street NAme")
    @Column(nullable = true)
	String street;
	
	@ApiModelProperty(value = "City Name")
    @Column(nullable = true)
	String city;
	
	@ApiModelProperty(value = "State Name")
    @Column(nullable = true)
	String state;
	
	@ApiModelProperty(value = "Postal code")
    @Column(nullable = true)
	String postalCode;
	
	@ApiModelProperty(value = "Country Name")
    @Column(nullable = true)
	String country;

	public long getAdresses_id() {
		return adresses_id;
	}

	public void setAdresses_id(long adresses_id) {
		this.adresses_id = adresses_id;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
