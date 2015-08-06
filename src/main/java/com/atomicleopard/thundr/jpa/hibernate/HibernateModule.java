package com.atomicleopard.thundr.jpa.hibernate;

import java.util.Properties;
import java.util.WeakHashMap;

import javax.persistence.AttributeConverter;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.hibernate.service.ServiceRegistry;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.InjectionContext;
import com.threewks.thundr.injection.UpdatableInjectionContext;

/**
 * Configures a basic, persistence.xml free Hibernate SessionFactory (for pure hibernate use) and
 * EntityManagerFactory (for JPA2 use).
 *
 * Configuration is obtained from a {@link PersistenceUnit} configuration object which must be configured before applications start.
 */
public class HibernateModule extends BaseModule {
	private WeakHashMap<String, SessionFactory> sessionFactories = new WeakHashMap<>();
	private WeakHashMap<String, EntityManagerFactory> entityManagerFactories = new WeakHashMap<>();

	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);
		PersistenceUnit unit = injectionContext.get(PersistenceUnit.class);
		createAndInjectSessionFactoryAndEntityManagerFactoryForPersistenceUnit(injectionContext, unit);
	}

	protected void createAndInjectSessionFactoryAndEntityManagerFactoryForPersistenceUnit(UpdatableInjectionContext injectionContext, PersistenceUnit unit) {
		Configuration configuration = new Configuration();
		for (Class<?> entityClass : unit.getEntityClasses()) {
			configuration.addAnnotatedClass(entityClass);
		}
		for (Class<? extends AttributeConverter<?, ?>> convertor : unit.getAttributeConvertors()) {
			configuration.addAttributeConverter(convertor);
		}
		Properties cfgProperties = configuration.getProperties();
		cfgProperties.put(Environment.DATASOURCE, unit.getDataSource());
		cfgProperties.put(Environment.DIALECT, unit.getDialect());

		StandardServiceRegistry serviceRegistry = createServiceRegistry(configuration);
		SessionFactory sessionFactory = createSessionFactory(configuration, serviceRegistry);

		// LocalSessionFactoryBuilder from Spring ORM is a world of interesting low level hacks
		// If you need to further customise hibernate, check it out and hack away
		// http://grepcode.com/file_/repo1.maven.org/maven2/org.springframework/spring-orm/4.1.6.RELEASE/org/springframework/orm/hibernate4/LocalSessionFactoryBuilder.java/?v=source

		EntityManagerFactory entityManagerFactory = new EntityManagerFactoryImpl(unit.getTransactionType(), unit.isReleaseResourcesOnCloseEnabled(), unit.getSessionInterceptorClass(), configuration,
				serviceRegistry, unit.getName());
		sessionFactories.put(unit.getName(), sessionFactory);
		entityManagerFactories.put(unit.getName(), entityManagerFactory);
		injectionContext.inject(sessionFactory).named(unit.getName()).as(SessionFactory.class);
		injectionContext.inject(entityManagerFactory).named(unit.getName()).as(EntityManagerFactory.class);
	}

	@Override
	public void stop(InjectionContext injectionContext) {
		super.stop(injectionContext);
		for (EntityManagerFactory factory : entityManagerFactories.values()) {
			factory.close();
		}
		for (SessionFactory sessionFactory : sessionFactories.values()) {
			sessionFactory.close();
		}
	}

	protected StandardServiceRegistry createServiceRegistry(Configuration configuration) {
		return new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	}

	protected SessionFactory createSessionFactory(Configuration configuration, ServiceRegistry serviceRegistry) {
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
