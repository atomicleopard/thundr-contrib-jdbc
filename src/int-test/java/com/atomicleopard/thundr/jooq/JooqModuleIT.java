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

import static org.hamcrest.Matchers.*;
import static org.jooq.impl.DSL.*;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.apache.commons.lang3.RandomStringUtils;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.SQLDataType;
import org.junit.Before;
import org.junit.Test;

import com.atomicleopard.thundr.jdbc.HikariModule;
import com.atomicleopard.thundr.jdbc.HsqlDbModule;
import com.atomicleopard.thundr.jdbc.JdbcModule;
import com.threewks.thundr.injection.InjectionContextImpl;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.Modules;
import com.zaxxer.hikari.HikariDataSource;

public class JooqModuleIT {

	public static final String JdbcUrl = "jdbc:hsqldb:mem";
	private UpdatableInjectionContext injectionContext = new InjectionContextImpl();
	private JooqModule module = new JooqModule();
	private Jooq jooq;

	@Before
	public void before() {
		String jdbcUrl = JdbcUrl;
		injectionContext.inject(jdbcUrl).as(String.class);
		injectionContext.inject("HSQLDB").named("jooq.dialect").as(String.class);
		injectionContext.inject(JdbcUrl).named("jdbc.url").as(String.class);
		HsqlDbModule hsqlDbModule = new HsqlDbModule();
		hsqlDbModule.initialise(injectionContext);

		module.start(injectionContext);
		jooq = injectionContext.get(Jooq.class);
	}

	@Test
	public void shouldStartAndInjectFactories() {
		assertThat(jooq.dialect(), is(SQLDialect.HSQLDB));
	}

	@Test
	public void shouldCreateTableAndSaveRecord() {
		createTableInsertAndReadRecord();
	}
	
	@Test
	public void shouldUsePooledConnectionForJooq() {
		Modules modules = new Modules();
		modules.addModule(JooqModule.class);
		modules.addModule(HikariModule.class);
		modules.addModule(HsqlDbModule.class);

		InjectionContextImpl injectionContext = new InjectionContextImpl();
		injectionContext.inject(JdbcUrl).named(JdbcModule.PropertyJdbcUrl).as(String.class);
		modules.runStartupLifecycle(injectionContext);

		DataSource dataSource = injectionContext.get(DataSource.class);
		assertThat(dataSource, is(notNullValue()));
		assertThat(dataSource, is(instanceOf(HikariDataSource.class)));
		
		createTableInsertAndReadRecord();
	}

	protected void createTableInsertAndReadRecord() {
		Table<Record> table = table("test_" + RandomStringUtils.randomAlphanumeric(10));
		Field<String> col1 = field("col_1", String.class);
		Field<Integer> col2 = field("col_2", Integer.class);
		// @formatter:off
		int result = jooq.createTable(table)
			.column(col1, SQLDataType.VARCHAR)
			.column(col2, SQLDataType.INTEGER)
			.execute();
		// @formatter:on
		assertThat(result, is(0));

		// @formatter:off
		int rows = jooq.insertInto(table)
			.set(col1, "var char")
			.set(col2, 123)
			.execute();
		// @formatter:on

		assertThat(rows, is(1));

		// @formatter:off
		Result<Record2<String, Integer>> results = jooq.select(col1, col2)
					.from(table)
					.limit(10)
					.fetch();
		// @formatter:on

		assertThat(results.size(), is(1));
		assertThat(results.get(0).getValue(col1), is("var char"));
		assertThat(results.get(0).getValue(col2), is(123));
	}
}