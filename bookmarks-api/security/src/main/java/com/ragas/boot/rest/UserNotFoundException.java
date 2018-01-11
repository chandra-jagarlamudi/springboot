/**
 * 
 */
package com.ragas.boot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Chandra Jagarlamudi
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String userId) {
		super("Could not find user '" + userId.toUpperCase() + "'.");
	}
}
