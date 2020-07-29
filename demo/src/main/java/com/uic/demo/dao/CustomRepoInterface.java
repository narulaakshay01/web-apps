package com.uic.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.User;

@Repository
//user entity is only used to fulfill crudrepository requirements, it is not used in this class
public interface CustomRepoInterface extends CrudRepository<User, Integer> {
	@Query(nativeQuery=true,value ="select column_name from information_schema.columns where table_schema='knowledge_hub' and table_name='user'")
	public List<String> getColumns();
}
