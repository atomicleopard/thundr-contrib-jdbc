/*
 * This file is a part of thundr-contrib-jdbc, a software library from Atomic Leopard.
 *
 * Copyright (C) 2015 Atomic Leopard, <nick@atomicleopard.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atomicleopard.thundr.jdbc;

import javax.sql.DataSource;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.InjectionContext;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;
import com.threewks.thundr.module.ModuleLoadingException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariModule extends BaseModule {
	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(JdbcModule.class);
	}

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
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

	@Override
	public void stop(InjectionContext injectionContext) {
		super.stop(injectionContext);
		HikariDataSource hikariDataSource = injectionContext.get(HikariDataSource.class);
		hikariDataSource.close();
	}
}
