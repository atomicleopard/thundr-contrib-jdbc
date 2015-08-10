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
package com.atomicleopard.thundr.jooq;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;

import com.atomicleopard.thundr.jdbc.JdbcModule;
import com.threewks.thundr.configuration.ConfigurationException;
import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;

public class JooqModule extends BaseModule {
	private static final String PropertyJooqDialect = "jooq.dialect";

	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(JdbcModule.class);
	}

	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);

		DataSource datasource = injectionContext.get(DataSource.class);

		String jooqDialect = injectionContext.get(String.class, PropertyJooqDialect);
		SQLDialect sqlDialect = getSqlDialect(datasource, jooqDialect);
		if (sqlDialect == null) {
			throw new ConfigurationException("JOOQ SQLDialect is unknown, please specify the name using the property '%s'", PropertyJooqDialect);
		}
		Jooq jooq = new Jooq(datasource, sqlDialect);
		injectionContext.inject(jooq).as(DSLContext.class);
		injectionContext.inject(jooq).as(Jooq.class);
	}

	protected SQLDialect getSqlDialect(DataSource datasource, String jooqDialect) {
		SQLDialect sqlDialect = parseSqlDialect(jooqDialect);
		if (sqlDialect == null) {
			sqlDialect = deriveDialect(datasource);
		}
		return sqlDialect;
	}

	protected SQLDialect deriveDialect(DataSource datasource) {
		return new JooqDialectResolver().determineDialect(datasource);
	}

	private SQLDialect parseSqlDialect(String jooqDialect) {
		if (jooqDialect == null) {
			return null;
		}
		try {
			return SQLDialect.valueOf(jooqDialect);
		} catch (Exception e) {
			throw new ConfigurationException("Failed to parse %s '%s' - must be on of the values in the enum %s", PropertyJooqDialect, jooqDialect, SQLDialect.class.getName());
		}
	}
}