package com.bosch.contact.model;

import java.util.Date;

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
public class PersonDetail {
	
	@ApiModelProperty(value = "person_detail_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long person_detail_id;
	
	@ApiModelProperty(value = "First Name")
    @Column(nullable = false)
	String firstName;
	
	@ApiModelProperty(value = "Last Name")
    @Column(nullable = true)
	String lastName;
	
	@ApiModelProperty(value = "Birthday")
    @Column(nullable = true)	
	Date dateOfBirth;

	

	public long getPerson_detail_id() {
		return person_detail_id;
	}

	public void setPerson_detail_id(long person_detail_id) {
		this.person_detail_id = person_detail_id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public PersonDetail(long person_detail_id, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.person_detail_id = person_detail_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public PersonDetail() {
		super();
	}
	
	

}
