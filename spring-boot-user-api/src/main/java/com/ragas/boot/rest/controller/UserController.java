/**
 * 
 */
package com.ragas.boot.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

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
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user ) {
		User newUser = userService.save(user);
		URI newUserLink = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		ResponseEntity.created(newUserLink).build();
		return ResponseEntity.created(newUserLink).build();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id){
		return userService.findOne(id);
	}

}
