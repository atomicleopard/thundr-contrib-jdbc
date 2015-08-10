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
