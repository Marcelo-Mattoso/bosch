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
public class Emails {
	
	@ApiModelProperty(value = "emails_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emails_id;
	
	@ApiModelProperty(value = "Email description name")
    @Column(nullable = true)
	String type;
	
	@ApiModelProperty(value = "Email")
    @Column(nullable = true)
	String value;

	public long getEmails_id() {
		return emails_id;
	}

	public void setEmails_id(long emails_id) {
		this.emails_id = emails_id;
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

	public Emails(long emails_id, String type, String value) {
		super();
		this.emails_id = emails_id;
		this.type = type;
		this.value = value;
	}

	public Emails() {
		super();
	}


	
}
