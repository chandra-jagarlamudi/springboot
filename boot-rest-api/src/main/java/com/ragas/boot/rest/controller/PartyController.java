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

import com.ragas.boot.rest.model.Party;
import com.ragas.boot.rest.model.PartyRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
@RequestMapping("/parties")
public class PartyController {

	@Autowired
	private PartyRepository partyRepository;

	@GetMapping
	public ResponseEntity<Collection<Party>> getParties() {
		return new ResponseEntity<>(partyRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Party> getParty(@PathVariable long id) {
		Party party = partyRepository.findOne(id);
		if (party != null) {
			return new ResponseEntity<>(partyRepository.findOne(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> addParty(@RequestBody Party party) {
		return new ResponseEntity<>(partyRepository.save(party), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePartyn(@PathVariable long id) {
		partyRepository.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
