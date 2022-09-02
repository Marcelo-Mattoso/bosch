package com.bosch.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Phones {
	
	@ApiModelProperty(value = "phones_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phones_id;
	
	@ApiModelProperty(value = "Phone description name")
    @Column(nullable = true)
	String type;
	
	@ApiModelProperty(value = "Phone")
    @Column(nullable = true)
	String value;

	public long getPhones_id() {
		return phones_id;
	}

	public void setPhones_id(long phones_id) {
		this.phones_id = phones_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
