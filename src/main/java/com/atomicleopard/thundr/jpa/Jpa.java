package com.atomicleopard.thundr.jpa;

import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.concurrent.Callable;

public interface Jpa {

	public EntityManager getEntityManager();

	public <T> T transact(Transaction transaction, Callable<EntityManager> trans);

}
