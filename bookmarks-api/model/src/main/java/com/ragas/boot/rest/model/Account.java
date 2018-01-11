/**
 * 
 */
package com.ragas.boot.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmarks = new HashSet<>();

	Account() { // jpa only
	}

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	@JsonIgnore
	public String password;
	public String username;

	public Account(String name, String password) {
		this.username = name;
		this.password = password;
	}
}
