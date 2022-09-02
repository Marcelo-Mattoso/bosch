package com.bosch.contact.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Person {

	@ApiModelProperty(value = "person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long person_id;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "person_detail_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	PersonDetail personDetails;
	
	@ApiModelProperty(value = "Company Name")
    @Column(nullable = true)
	String company;
	
	@ApiModelProperty(value = "Profile Image")
    @Column(nullable = true)
	String profileImage; 
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Emails> email;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Phones> phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "person_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Addresses> address;

	public long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}

	public PersonDetail getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetail personDetails) {
		this.personDetails = personDetails;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<Emails> getEmail() {
		return email;
	}

	public void setEmail(List<Emails> email) {
		this.email = email;
	}

	public List<Phones> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<Phones> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Addresses> getAddress() {
		return address;
	}

	public void setAddress(List<Addresses> address) {
		this.address = address;
	}

	public Person() {
		super();
	}



	
	
}
