package com.keylane.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "person")
public class PersonCq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Transient
	private Long age;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column
	private String birthPlace;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime changeTime;

	@Temporal(TemporalType.DATE)
	private Date deathDate;

	@Column
	private String emailAddress;

	@Column
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy = "personCq", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Policy> policyList = new ArrayList<>();

	public PersonCq() {
		super();
	}

	public PersonCq(Long id, String name, Long age, Date birthDate, String birthPlace, LocalDateTime changeTime,
			Date deathDate, String emailAddress, String phoneNumber, Gender gender, Address address,
			List<Policy> policyList) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.changeTime = changeTime;
		this.deathDate = deathDate;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.address = address;
		this.policyList = policyList;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalDateTime getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(LocalDateTime changeTime) {
		this.changeTime = changeTime;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
