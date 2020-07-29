package com.uic.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.Reviewer;

@Repository
public interface ReviewerRepoInterface extends CrudRepository<Reviewer, Integer> {
	public List<Reviewer> findByName(String name);
}
