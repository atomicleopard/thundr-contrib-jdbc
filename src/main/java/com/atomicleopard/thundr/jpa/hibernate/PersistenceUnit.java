package com.atomicleopard.thundr.jpa.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.dialect.Dialect;

public class PersistenceUnit {
	protected String name;
	protected DataSource dataSource;
	protected Map<String, String> properties = new HashMap<>();
	
	public PersistenceUnit(String name, Dialect dialect, DataSource dataSource, Map<String, String> properties) {
		super();
		this.name = name;
		this.dialect = dialect;
		this.dataSource = dataSource;
		this.properties = properties;
	}
	
	public PersistenceUnit(String name, Map<String, String> properties) {
		super();
		this.name = name;
		this.dialect = dialect;
		this.dataSource = dataSource;
		this.properties = properties;
	}
	

	
}
