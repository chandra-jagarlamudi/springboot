package com.ragas.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Entity
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;

	public Course() {

	}

	public Course(final String id, final String name, final String description, final String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(final Topic topic) {
		this.topic = topic;
	}

}
