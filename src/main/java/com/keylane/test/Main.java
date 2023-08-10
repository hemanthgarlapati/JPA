package com.keylane.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

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

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("policy");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Address address = new Address();
		address.setCountry("India");
		address.setCity("Hyderabad");
		address.setPostalCode("500001");
		
		Address address1 = new Address();
		address1.setCountry("DK");
		address1.setCity("Copenhagen");
		address1.setPostalCode("1000");

		PersonCq personCq = new PersonCq();
		personCq.setName("Andre");
		personCq.setBirthDate(LocalDate.of(1960, 02, 20));
		personCq.setBirthPlace("Hyderabad");
		personCq.setChangeTime(LocalDateTime.now());
		personCq.setDeathDate(LocalDate.of(2020, 02, 25));
		personCq.setEmailAddress("andre@yahoo.com");
		personCq.setGender(Gender.MALE);
		personCq.setPhoneNumber("9995892499");
		personCq.setAddress(address);
		
		PersonCq personCq1 = new PersonCq();
		personCq1.setName("mathew");
		personCq1.setBirthDate(LocalDate.of(1960, 02, 20));
		personCq1.setBirthPlace("Malmo");
		personCq1.setChangeTime(LocalDateTime.now());
		personCq1.setDeathDate(LocalDate.of(2020, 02, 25));
		personCq1.setEmailAddress("mathew@yahoo.com");
		personCq1.setGender(Gender.MALE);
		personCq1.setPhoneNumber("9254558429");
		personCq1.setAddress(address1);

		Policy policy1 = new Policy();
		policy1.setPolicyNumber("12345");
		policy1.setPolicyName("Health");
		

		Policy policy2 = new Policy();
		policy2.setPolicyNumber("56789");
		policy2.setPolicyName("Life");
		
		personCq.setPolicies(Arrays.asList(policy1));
		personCq1.setPolicies(Arrays.asList(policy1,policy2));

		

		entityManager.persist(personCq);
		entityManager.persist(personCq1);
		
		entityManager.getTransaction().commit();
	}
}
