package com.atomicleopard.thundr.jpa;

import javax.persistence.EntityManager;

public class SimpleService {
	private Jpa jpa;

	public SimpleService(Jpa users, Jpa accounts, Jpa dev) {
		EntityManager entityManager = jpa.getEntityManager();
		
	}
}
