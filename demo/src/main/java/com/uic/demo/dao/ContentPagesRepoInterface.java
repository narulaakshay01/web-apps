package com.uic.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uic.demo.entity.ContentPages;
import com.uic.demo.entity.ContentPagesKey;

@Repository
public interface ContentPagesRepoInterface extends CrudRepository<ContentPages, ContentPagesKey> {

}
