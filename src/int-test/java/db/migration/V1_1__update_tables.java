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
package db.migration;
import static org.jooq.impl.DSL.*;

import java.sql.Connection;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.SQLDataType;

import com.atomicleopard.thundr.jooq.Jooq;

public class V1_1__update_tables implements JdbcMigration {

	@Override
	public void migrate(Connection connection) throws Exception {
		Jooq jooq = new Jooq(connection, SQLDialect.HSQLDB);
		Table<Record> table = table("test_user");
		Field<Integer> field = field("is_rad", Integer.class);
		jooq.alterTable(table)
			.add(field, SQLDataType.INTEGER.nullable(true))
			.execute();
		
		connection.commit();
	}

}
