package com.atomicleopard.thundr.jpa.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.Interceptor;
import org.hibernate.dialect.Dialect;

public class PersistenceUnit {
	protected String name = "default";
	protected DataSource dataSource;
	protected Map<String, String> properties = new HashMap<>();
	protected List<Class<?>> entities = new ArrayList<>();
	protected Dialect dialect;
	protected PersistenceUnitTransactionType transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
	protected boolean releaseResourcesOnCloseEnabled = false;
	protected Class<? extends Interceptor> sessionInterceptorClass;
	protected List<Class<? extends AttributeConverter<?, ?>>> convertors = new ArrayList<>();

	// TODO - Dialect should be totally derivable from all known datasources
	public PersistenceUnit(DataSource dataSource, Dialect dialect) {
		super();
		this.dataSource = dataSource;
		this.dialect = dialect;
	}

	public PersistenceUnit withName(String name) {
		this.name = name;
		return this;
	}

	public PersistenceUnit withProperty(String key, String value) {
		this.properties.put(key, value);
		return this;
	}

	public PersistenceUnit withProperties(Map<String, String> properties) {
		this.properties.putAll(properties);
		return this;
	}

	public PersistenceUnit withEntity(Class<?> entity) {
		this.entities.add(entity);
		return this;
	}

	public PersistenceUnit withEntities(Class<?>... entities) {
		this.entities.addAll(Arrays.asList(entities));
		return this;
	}

	public PersistenceUnit withTransactionType(PersistenceUnitTransactionType transactionType) {
		this.transactionType = transactionType;
		return this;
	}

	public PersistenceUnit withConvertor(Class<? extends AttributeConverter<?, ?>> convertor) {
		this.convertors.add(convertor);
		return this;
	}

	@SuppressWarnings("unchecked")
	public PersistenceUnit withConvertors(Class<? extends AttributeConverter<?, ?>>... convertors) {
		this.convertors.addAll(Arrays.asList(convertors));
		return this;
	}

	public PersistenceUnit withReleaseResourcesOnCloseEnabled(boolean releaseResourcesOnCloseEnabled) {
		this.releaseResourcesOnCloseEnabled = releaseResourcesOnCloseEnabled;
		return this;
	}

	public PersistenceUnit withSessionInterceptorClass(Class<? extends Interceptor> sessionInterceptorClass) {
		this.sessionInterceptorClass = sessionInterceptorClass;
		return this;
	}

	public Dialect getDialect() {
		return dialect;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public List<Class<?>> getEntityClasses() {
		return entities;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public PersistenceUnitTransactionType getTransactionType() {
		return transactionType;
	}

	public Class<? extends Interceptor> getSessionInterceptorClass() {
		return sessionInterceptorClass;
	}

	public boolean isReleaseResourcesOnCloseEnabled() {
		return releaseResourcesOnCloseEnabled;
	}

	public List<Class<? extends AttributeConverter<?, ?>>> getAttributeConvertors() {
		return convertors;
	}

}
