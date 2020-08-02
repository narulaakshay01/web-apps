package com.uic.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "content_pages")
public class ContentPages {

	@EmbeddedId
	private ContentPagesKey primaryKey;
	private String type;
	private String path;

	public ContentPages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentPages(ContentPagesKey primaryKey, String type, String path) {
		super();
		this.primaryKey = primaryKey;
		this.type = type;
		this.path = path;
	}

	public ContentPagesKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ContentPagesKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ContentPages [primaryKey=" + primaryKey + ", type=" + type + ", path=" + path + "]";
	}

}