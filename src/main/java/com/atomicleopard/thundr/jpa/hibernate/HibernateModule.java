package com.atomicleopard.thundr.jpa.hibernate;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;

public class HibernateModule extends BaseModule {
	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);
		
		//
		// persistence-units%dev=users-dev-db.properties,accounts-dev-db.properties
		// persistence-units%prod=users-prod-db.properties,accounts-prod-db.properties
		// persistence-dev.xml
		// hibernate-dialect=HSQLDB
		
	}
}
