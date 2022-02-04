package com.nit.entity;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSON_INFO")
@Setter
@Getter

public class Person {

	@Id
	@SequenceGenerator(name = "gen1" ,allocationSize = 1,initialValue = 101,sequenceName = "PID_SEQ1")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@Column(length = 20)
	private String pname;
	
	@Column(length = 20)
	private String address;
	
//	@OneToMany(targetEntity = PersonPhoneNo.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@OneToMany(targetEntity = PersonPhoneNo.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PersonPhoneNo>  phoneNo;

	@Override
	public String toString() {
		return "Person(Parent) [pid=" + pid + ", pname=" + pname + ", address=" + address + "]";
	}
	
	
	
}
