package com.atomicleopard.thundr.jdbc;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;

public class HsqlDbModule extends BaseModule {

	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
	}

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
		String jdbcUrl = injectionContext.get(String.class, "jdbc.url");
		JDBCDataSource jdbcDataSource = new JDBCDataSource();
		jdbcDataSource.setDatabase(jdbcUrl);

		injectionContext.inject(jdbcDataSource).as(DataSource.class);
	}
}