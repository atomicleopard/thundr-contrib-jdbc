package com.atomicleopard.thundr.jpa;

import java.sql.DriverManager;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.spi.PersistenceProvider;
import javax.print.attribute.standard.DialogTypeSelection;

import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;

public class JpaModule extends BaseModule {
	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);
	}
}
