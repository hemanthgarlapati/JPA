package com.keylane.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column
	private String policyNumber;

	@Column
	private String policyName;

	@ManyToMany(mappedBy = "policies")
    private List<PersonCq> persons = new ArrayList<>();

	public Policy() {
		super();
	}

	

	public Policy(Integer id, String policyNumber, String policyName, List<PersonCq> persons) {
		super();
		Id = id;
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.persons = persons;
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



	public List<PersonCq> getPersons() {
		return persons;
	}



	public void setPersons(List<PersonCq> persons) {
		this.persons = persons;
	}

	

}
