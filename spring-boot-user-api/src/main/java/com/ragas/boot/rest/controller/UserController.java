/**
 * 
 */
package com.ragas.boot.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ragas.boot.rest.exception.UserNotFoundException;
import com.ragas.boot.rest.persistence.model.User;
import com.ragas.boot.rest.service.UserService;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User newUser = userService.save(user);
		URI newUserLink = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(newUserLink).build();
	}

	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		User newUser = userService.findOne(id);
		if (null == newUser) {
			throw new UserNotFoundException(String.format("User with ID %s not found", id));
		}

		//Creating a resource
		Resource<User> resource = new Resource<User>(newUser);

		//Creating link to all users and adding to the response
		ControllerLinkBuilder linkToUsers = linkTo(methodOn(this.getClass(), "getUsers"));
		resource.add(linkToUsers.withRel("all-users"));

		return resource;
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		boolean status = userService.deleteUser(id);
		if (!status) {
			throw new UserNotFoundException(String.format("User with ID %s not found", id));
		}
		return ResponseEntity.noContent().build();
	}

}
