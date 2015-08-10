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
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;

/**
 * A common base class for thundr jdbc modules allowing for simple creation.
 */
public abstract class BaseJdbcModule extends BaseModule {
	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(JdbcModule.class);
	}

	@Override
	public void initialise(UpdatableInjectionContext injectionContext) {
		String jdbcUrl = injectionContext.get(String.class, JdbcModule.PropertyJdbcUrl);
		DataSource dataSource = createDataSource(injectionContext, jdbcUrl);
		injectionContext.inject(dataSource).as(DataSource.class);
	}

	protected abstract DataSource createDataSource(UpdatableInjectionContext injectionContext, String jdbcUrl);
}