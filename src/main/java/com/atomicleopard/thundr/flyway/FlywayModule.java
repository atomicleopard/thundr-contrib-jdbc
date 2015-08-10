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
