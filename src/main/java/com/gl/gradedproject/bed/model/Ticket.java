package com.gl.gradedproject.bed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "comment")
	private String comment;
	@CreationTimestamp
	@Column(name = "createdOn")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;

	public Ticket() {
	}

	public Ticket(long id, String title, String description, String comment, Date createdOn) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.comment = comment;
		this.createdOn = new Date();
	}

	public Ticket(String title, String description, String comment, Date createdOn) {
		this.title = title;
		this.description = description;
		this.comment = comment;
		this.createdOn = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = new Date();
	}
}
