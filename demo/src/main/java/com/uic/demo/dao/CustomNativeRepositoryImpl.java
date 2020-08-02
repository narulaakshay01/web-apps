package com.uic.demo.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class CustomNativeRepositoryImpl implements CustomNativeRepository {

	@Autowired
	private DataSource dataSource;

	@Override
	public void init() {
		Resource resource = new ClassPathResource("schema.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.setSeparator("^;");
		databasePopulator.execute(dataSource);

		resource = new ClassPathResource("data.sql");
		databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.setSeparator("^;");
		databasePopulator.execute(dataSource);

	}
}