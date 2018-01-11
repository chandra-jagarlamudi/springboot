/**
 * 
 */
package com.ragas.boot.rest;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ragas.boot.rest.model.AccountRepository;
import com.ragas.boot.rest.model.Bookmark;
import com.ragas.boot.rest.model.BookmarkRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
@RequestMapping("/{userId}/bookmarks")
public class BookmarkController {
	@Autowired
	private BookmarkRepository bookmarkRepository;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	Collection<Bookmark> getBookmarks(@PathVariable String userId) {
		this.validateUser(userId);
		return this.bookmarkRepository.findByAccountUsername(userId);
	}

	@PostMapping
	ResponseEntity<?> addBookmark(@PathVariable String userId, @RequestBody Bookmark input) {
		this.validateUser(userId);
		return this.accountRepository.findByUsername(userId).map(account -> {
			Bookmark result = bookmarkRepository.save(new Bookmark(account, input.uri, input.description));
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}).orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/{bookmarkId}")
	Bookmark getBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		this.validateUser(userId);
		Optional<Bookmark> optionalBookmark = this.bookmarkRepository.findById(bookmarkId);
		return optionalBookmark.isPresent() ? optionalBookmark.get()
				: new Bookmark(accountRepository.findByUsername(userId).get(), "uri", "description");
	}

	private void validateUser(String userId) {
		this.accountRepository
		.findByUsername(userId)
		.orElseThrow(
				() -> new UserNotFoundException(userId));
	}
}
