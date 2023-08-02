package com.keylane.test;

import java.time.LocalDateTime;
import java.util.Date;

import com.keylane.entity.Address;
import com.keylane.entity.Gender;
import com.keylane.entity.PersonCq;
import com.keylane.entity.Policy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		insertPerson();
	}

	public static void insertPerson() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Address address = new Address();
		address.setCountry("India");
		address.setCity("Hyderabad");
		address.setPostalCode("500001");

		PersonCq personCq = new PersonCq();
		personCq.setName("Andre");
		personCq.setBirthDate(new Date(2000, 10, 10));
		personCq.setBirthPlace("Hyderabad");
		personCq.setChangeTime(LocalDateTime.now());
		personCq.setDeathDate(new Date());
		personCq.setEmailAddress("andre@yahoo.com");
		personCq.setGender(Gender.MALE);
		personCq.setPhoneNumber("999999999");
		personCq.setAddress(address);

		Policy policy1 = new Policy();
		policy1.setPolicyNumber("12345");
		policy1.setPolicyName("Health");
		policy1.setPersonCq(personCq);

		Policy policy2 = new Policy();
		policy2.setPolicyNumber("56789");
		policy2.setPolicyName("Life");
		policy2.setPersonCq(personCq);

		personCq.getPolicyList().add(policy1);
		personCq.getPolicyList().add(policy2);

		entityManager.persist(personCq);
		entityManager.getTransaction().commit();
	}
}
