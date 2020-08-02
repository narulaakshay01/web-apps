package com.uic.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ContentPagesKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "content_id", referencedColumnName = "id")
	private Content contentId;
	private Integer id;

	public Content getContentId() {
		return contentId;
	}

	public void setContentId(Content contentId) {
		this.contentId = contentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
