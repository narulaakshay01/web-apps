package com.uic.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.Content;

@Repository
public interface ContentRepoInterface extends CrudRepository<Content, Integer> {
    
}
