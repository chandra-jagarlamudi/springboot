/**
 * 
 */
package com.ragas.boot.rest;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	Collection<BookmarkResource> getBookmarks(@PathVariable String userId) {
		this.validateUser(userId);
		List<BookmarkResource> bookmarkResourceList = bookmarkRepository.findByAccountUsername(userId).stream()
				.map(BookmarkResource::new).collect(Collectors.toList());
		return bookmarkResourceList;
	}

	@PostMapping
	ResponseEntity<?> addBookmark(@PathVariable String userId, @RequestBody Bookmark input) {
		this.validateUser(userId);
		return accountRepository.findByUsername(userId).map(account -> {
			Bookmark bookmark = bookmarkRepository.save(new Bookmark(account, input.uri, input.description));
			Link forOneBookmark = new BookmarkResource(bookmark).getLink("self");
			return ResponseEntity.created(URI.create(forOneBookmark.getHref())).build();
		}).orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/{bookmarkId}")
	BookmarkResource getBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		validateUser(userId);
		Optional<Bookmark> optionalBookmark = bookmarkRepository.findById(bookmarkId);
		Bookmark bookmark = optionalBookmark.isPresent() ? optionalBookmark.get()
				: new Bookmark(accountRepository.findByUsername(userId).get(), "uri", "description");
		return new BookmarkResource(bookmark);
	}

	private void validateUser(String userId) {
		this.accountRepository
		.findByUsername(userId)
		.orElseThrow(
				() -> new UserNotFoundException(userId));
	}
}
