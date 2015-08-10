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

import static com.atomicleopard.expressive.Expressive.map;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.jooq.SQLDialect;

import com.threewks.thundr.exception.BaseException;

public class JooqDialectResolver {
	// @formatter:off
	public static Map<String, SQLDialect> lookups = map(
			"cubrid", SQLDialect.CUBRID,
			"hsql database engine", SQLDialect.HSQLDB,
			"h2", SQLDialect.H2,
			"mysql", SQLDialect.MYSQL,
			"postgresql", SQLDialect.POSTGRES_9_4,
			"apache derby", SQLDialect.DERBY,
			"firebird", SQLDialect.FIREBIRD
	);
	
	// @formatter:on
	public SQLDialect determineDialect(DataSource datasource) {
		try {
			Connection connection = datasource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			String databaseName = metaData.getDatabaseProductName().toLowerCase();
			SQLDialect lookedUp = lookups.get(databaseName);
			return lookedUp;
		} catch (SQLException e) {
			throw new BaseException(e, "Failed to use jdbc connection to determine JOOQ SQLDialect - please specify the dialect directly: %s", e.getMessage());
		}
	}
}
