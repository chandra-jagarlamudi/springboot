/**
 * 
 */
package com.ragas.boot.rest;

import java.net.URI;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
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
@RequestMapping("/bookmarks")
public class BookmarkController {
	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	Collection<BookmarkResource> getBookmarks(Principal principal) {
		validateUser(principal);
		List<BookmarkResource> bookmarkResourceList = bookmarkRepository.findByAccountUsername(principal.getName())
				.stream().map(BookmarkResource::new).collect(Collectors.toList());
		return bookmarkResourceList;
	}

	@PostMapping
	ResponseEntity<?> addBookmark(Principal principal, @RequestBody Bookmark input) {
		validateUser(principal);
		return accountRepository.findByUsername(principal.getName()).map(account -> {
			Bookmark bookmark = bookmarkRepository.save(new Bookmark(account, input.uri, input.description));
			Link forOneBookmark = new BookmarkResource(bookmark).getLink("self");
			return ResponseEntity.created(URI.create(forOneBookmark.getHref())).build();
		}).orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/{bookmarkId}")
	BookmarkResource getBookmark(Principal principal, @PathVariable Long bookmarkId) {
		validateUser(principal);
		Optional<Bookmark> optionalBookmark = bookmarkRepository.findById(bookmarkId);
		Bookmark bookmark = optionalBookmark.isPresent() ? optionalBookmark.get()
				: new Bookmark(accountRepository.findByUsername(principal.getName()).get(), "uri", "description");
		return new BookmarkResource(bookmark);
	}

	private void validateUser(Principal principal) {
		String userId = principal.getName();
		accountRepository
		.findByUsername(userId)
		.orElseThrow(
				() -> new UserNotFoundException(userId));
	}
}
