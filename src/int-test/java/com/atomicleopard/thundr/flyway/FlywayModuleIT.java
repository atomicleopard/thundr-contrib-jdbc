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

import static org.hamcrest.Matchers.is;
import static org.jooq.impl.DSL.*;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atomicleopard.thundr.jdbc.HsqlDbModule;
import com.atomicleopard.thundr.jdbc.JdbcModule;
import com.atomicleopard.thundr.jooq.Jooq;
import com.threewks.thundr.injection.InjectionContextImpl;

public class FlywayModuleIT {
	public static final String JdbcUrl = "jdbc:hsqldb:mem:aname";
	private FlywayModule flywayModule = new FlywayModule();
	private HsqlDbModule hsqldbModule = new HsqlDbModule();
	private InjectionContextImpl injectionContext = new InjectionContextImpl();
	private DataSource dataSource;
	private Jooq jooq;

	@Before
	public void before() {
		injectionContext.inject(JdbcUrl).named(JdbcModule.PropertyJdbcUrl).as(String.class);
		injectionContext.inject("true").named(FlywayModule.PropertyBaselineOnMigrate).as(String.class);
		hsqldbModule.initialise(injectionContext);
		dataSource = injectionContext.get(DataSource.class);
		jooq = new Jooq(dataSource, SQLDialect.HSQLDB);
//		jooq.execute("DROP SCHEMA PUBLIC CASCADE");
	}
	
	@After
	public void after() {
	//	jooq.execute("DROP SCHEMA PUBLIC CASCADE");
	}

	@Test
	public void shouldRunMigrationsAtStart() {
		flywayModule.start(injectionContext);
		
		Table<Record> table = table("test_user");
		Field<String> name = field("name", String.class);
		Field<Integer> isRad = field("is_rad", Integer.class);

		Result<Record> all = jooq.select()
			.from(table)
			.fetch();
		
		assertThat(all.size(), is(0));
		assertThat(all.fields().length, is(2));

		int rows = jooq.insertInto(table, name, isRad)
			.values("test", 123)
			.execute();
		
		assertThat(rows, is(1));
		
		Result<Record2<String, Integer>> results = jooq.select(name, isRad)
			.from(table)
			.fetch();
		
		assertThat(results.size(), is(1));
		assertThat(results.get(0).getValue(name), is("test"));
		assertThat(results.get(0).getValue(isRad), is(123));
	}
}
