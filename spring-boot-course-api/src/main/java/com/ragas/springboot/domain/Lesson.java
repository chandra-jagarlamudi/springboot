package com.ragas.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Entity
public class Lesson {
	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Course course;

	public Lesson() {

	}

	public Lesson(final String id, final String name, final String description, final String courseId,
			final String topicId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId, "", "", topicId);
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(final Course course) {
		this.course = course;
	}

}