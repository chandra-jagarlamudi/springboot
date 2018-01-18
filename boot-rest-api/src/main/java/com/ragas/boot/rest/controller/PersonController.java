/**
 * 
 */
package com.ragas.boot.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.boot.rest.model.Person;
import com.ragas.boot.rest.model.PersonRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */

@RestController
@RequestMapping("/people")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@GetMapping
	public ResponseEntity<Collection<Person>> getPeople() {
		return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable long id) {
		Person person = personRepository.findOne(id);
		if (person != null) {
			return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
		return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable long id) {
		personRepository.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
