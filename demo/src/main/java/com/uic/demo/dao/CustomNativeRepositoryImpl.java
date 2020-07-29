package com.uic.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomNativeRepositoryImpl implements CustomNativeRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Object runNativeQuery() {
		return entityManager.createNativeQuery("select column_name from information_schema.columns where table_schema='knowledge_hub' and table_name='user'").getResultList();
	}
}