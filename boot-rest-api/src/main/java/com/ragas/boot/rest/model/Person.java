/**
 * 
 */
package com.ragas.boot.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chandra Jagarlamudi
 *
 */

@Entity
@Table(name = "people")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;

	private String name;

	private int age;

	public Person() {
		// empty constuctor for Hibernate
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
