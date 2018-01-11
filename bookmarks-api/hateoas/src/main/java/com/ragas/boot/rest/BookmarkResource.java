/**
 * 
 */
package com.ragas.boot.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.ragas.boot.rest.model.Bookmark;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class BookmarkResource extends ResourceSupport {
	private final Bookmark bookmark;

	public BookmarkResource(Bookmark bookmark) {
		String username = bookmark.getAccount().getUsername();
		this.bookmark = bookmark;
		this.add(new Link(bookmark.getUri(), "bookmark-uri"));
		this.add(linkTo(BookmarkController.class, username).withRel("bookmarks"));
		this.add(linkTo(methodOn(BookmarkController.class, username)
				.getBookmark(username, bookmark.getId())).withSelfRel());
	}

	public Bookmark getBookmark() {
		return bookmark;
	}
}
