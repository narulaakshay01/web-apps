package com.uic.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity(name = "user_activity")
public class UserActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "content_id", referencedColumnName = "content_id"),
			@JoinColumn(name = "page_id", referencedColumnName = "id") })
	public ContentPages contentPagesId;
	private Date viwedOn;

	public UserActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserActivity(User userId, ContentPages contentPagesId, Date viwedOn) {
		super();
		this.userId = userId;
		this.contentPagesId = contentPagesId;
		this.viwedOn = viwedOn;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public ContentPages getContentPagesId() {
		return contentPagesId;
	}

	public void setContentPagesId(ContentPages contentPagesId) {
		this.contentPagesId = contentPagesId;
	}

	public Date getViwedOn() {
		return viwedOn;
	}

	public void setViwedOn(Date viwedOn) {
		this.viwedOn = viwedOn;
	}

}