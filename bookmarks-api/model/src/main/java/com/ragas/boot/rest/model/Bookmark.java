/**
 * 
 */
package com.ragas.boot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Entity
public class Bookmark {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Account account;

	public String uri;
	public String description;

	public Bookmark() { // jpa only
	}

	public Bookmark(Account account, String uri, String description) {
		this.uri = uri;
		this.description = description;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public Long getId() {
		return id;
	}

	public String getUri() {
		return uri;
	}

	public String getDescription() {
		return description;
	}
}
