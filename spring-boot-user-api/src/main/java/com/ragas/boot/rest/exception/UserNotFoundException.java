/**
 * 
 */
package com.ragas.boot.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Chandra Jagarlamudi
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6913814882673368603L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
