package com.uic.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	private String name;
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reviewer_id", referencedColumnName = "id")
	private Reviewer reviewer;
	private Boolean isActive;

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Content(Integer id, String name, String description, Author author, Reviewer reviewer, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.reviewer = reviewer;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", name=" + name + ", description=" + description + ", author=" + author
				+ ", reviewer=" + reviewer + ", isActive=" + isActive + "]";
	}

}