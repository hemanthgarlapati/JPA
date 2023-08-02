package com.keylane.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column
	private String policyNumber;

	@Column
	private String policyName;

	@ManyToOne
	private PersonCq personCq;

	public Policy() {
		super();
	}

	public Policy(Integer id, String policyNumber, String policyName, PersonCq personCq) {
		super();
		Id = id;
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.personCq = personCq;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public PersonCq getPersonCq() {
		return personCq;
	}

	public void setPersonCq(PersonCq personCq) {
		this.personCq = personCq;
	}

}
