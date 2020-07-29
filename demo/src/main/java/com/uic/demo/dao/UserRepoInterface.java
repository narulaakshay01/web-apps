package com.uic.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.User;

@Repository
public interface UserRepoInterface extends CrudRepository<User, Integer> {
    
	public List<User> findByName(String name);
}
