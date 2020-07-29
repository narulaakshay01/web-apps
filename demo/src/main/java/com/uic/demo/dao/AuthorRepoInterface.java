package com.uic.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.Author;

@Repository
public interface AuthorRepoInterface extends CrudRepository<Author, Integer> {
	public List<Author> findByName(String name);
}
