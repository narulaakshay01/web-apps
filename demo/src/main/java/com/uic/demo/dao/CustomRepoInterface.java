package com.uic.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.User;

@Repository
//user entity is only used to fulfill crudrepository requirements, it is not used in this class
public interface CustomRepoInterface extends CrudRepository<User, Integer> {
	
	@Query(nativeQuery=true,value ="call trivial(?1);")
	public List<Map<String, Object>> getTrivial(int num);
	
	@Query(nativeQuery=true,value ="call complex(?1);")
	public List<Map<String, Object>> getComplex(int num);
}
