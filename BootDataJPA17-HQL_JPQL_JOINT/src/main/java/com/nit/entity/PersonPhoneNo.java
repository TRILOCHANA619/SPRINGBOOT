package com.nit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PHONE_NUMBER_DETAILS")
@Setter
@Getter
public class PersonPhoneNo {

	@Id
	@GeneratedValue
	private Integer redg;
	
	@Column(length = 20)
	private String ProviderName;
	
	
	private Long Number;
	
	@Column(length = 20)
	private String type;
	
	//many to one
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = Person.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Person person;

	@Override
	public String toString() {
		return "PersonPhoneNo(child) [redg=" + redg + ", ProviderName=" + ProviderName + ", Number=" + Number + ", type="
				+ type + "]";
	}
	
	//taking the property for the FK column is optional
	
	
	
}
