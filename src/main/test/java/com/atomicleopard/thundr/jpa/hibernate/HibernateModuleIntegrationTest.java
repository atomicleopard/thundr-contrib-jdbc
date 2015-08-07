package com.atomicleopard.thundr.jpa.hibernate;

import com.atomicleopard.thundr.jdbc.HsqlDbModule;
import com.threewks.thundr.injection.InjectionContextImpl;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by kaushiksen on 7/08/2015.
 */
public class HibernateModuleIntegrationTest {

    public static final String CUST_NAME = "cust_name";
    public static final String JDBC_URL = "jdbc:hsqldb:mem:test;user=sa;password=";
    Connection connection = null;
    private UpdatableInjectionContext injectionContext = new InjectionContextImpl();
    private HibernateModule hibernateModule = null;
    private HsqlDbModule hsqlDbModule = null;
    PersistenceUnit persistenceUnit = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    Customer customer = null;

    @Before
    public void before() {
        String jdbcUrl = JDBC_URL;
        injectionContext.inject(jdbcUrl).as(String.class);
        hsqlDbModule = new HsqlDbModule();
        hsqlDbModule.configure(injectionContext);
        DataSource dataSource = injectionContext.get(DataSource.class);
        persistenceUnit = new PersistenceUnit(dataSource)
                .withEntity(Customer.class);
        injectionContext.inject(persistenceUnit).as(PersistenceUnit.class);
        hibernateModule = new HibernateModule();
        hibernateModule.start(injectionContext);

        customer = new Customer();
        customer.setName(CUST_NAME);
    }

    @Test
    public void shouldStartAndInjectFactories() {
        sessionFactory = injectionContext.get(SessionFactory.class);
        session = sessionFactory.openSession();
        entityManagerFactory = injectionContext.get(EntityManagerFactory.class);
        entityManager = entityManagerFactory.createEntityManager();
        assertTrue(session.isConnected());
        assertTrue(entityManager.isOpen());
    }

    @Test
    public void shouldPersistEntity() {
        sessionFactory = injectionContext.get(SessionFactory.class);
        session = sessionFactory.openSession();
        session.persist(customer);
        session.flush();

    }

    @After
    public void after() {
        if (session != null)
            session.close();
        if (entityManager != null)
            entityManager.close();
    }

}