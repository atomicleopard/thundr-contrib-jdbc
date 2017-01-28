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
package com.atomicleopard.thundr.flyway;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.flywaydb.core.Flyway;

import com.atomicleopard.expressive.Expressive;
import com.atomicleopard.thundr.jdbc.JdbcModule;
import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;

public class FlywayModule extends BaseModule {
	public static final String PropertyBaselineOnMigrate = "flyway.baselineonmigrate";
	public static final String PropertyPlaceHolders = "flyway.placeholders";

	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(JdbcModule.class);
	}

	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);
		DataSource dataSource = injectionContext.get(DataSource.class);

		boolean baselineOnMigrate = Boolean.TRUE.equals(injectionContext.get(Boolean.class, PropertyBaselineOnMigrate));
		Map<String, String> placeholders = getPropertyPlaceholders(injectionContext);

		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(baselineOnMigrate);
		flyway.setPlaceholders(placeholders);
		flyway.setDataSource(dataSource);
		// TODO - NAO - We can add more resolvers, for example allowing a Jooq, JPA or JDO resolver. Possibly just an InjectionContext resolver
		// which binds everything including services into the resolved migrator
		// flyway.getResolvers()
		flyway.migrate();
	}

	protected Map<String, String> getPropertyPlaceholders(UpdatableInjectionContext injectionContext) {
		String placeholderStrings = injectionContext.get(String.class, PropertyPlaceHolders);
		Map<String, String> placeholders = new HashMap<>();
		if (StringUtils.isNotBlank(placeholderStrings)) {
			Object[] split = placeholderStrings.split(",");
			placeholders.putAll(Expressive.<String, String> map(split));
		}
		return placeholders;
	}
}
