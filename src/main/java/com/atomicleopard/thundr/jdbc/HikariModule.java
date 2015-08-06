package com.atomicleopard.thundr.jdbc;

import javax.sql.DataSource;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.ModuleLoadingException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariModule extends BaseModule {
	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		DataSource underlyingDataSource = injectionContext.get(DataSource.class);
		if (underlyingDataSource == null) {
			throw new ModuleLoadingException("No %s available - make sure you configure and inject a JDBC %s", DataSource.class.getSimpleName(), DataSource.class.getName());
		}

		HikariConfig hikariConfig = injectionContext.get(HikariConfig.class);
		if (hikariConfig == null) {
			hikariConfig = new HikariConfig();
			// sensible defaults
		}
		hikariConfig.setDataSource(underlyingDataSource);
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		injectionContext.inject(dataSource).as(HikariDataSource.class);
		injectionContext.inject(dataSource).as(DataSource.class);
	}
}
