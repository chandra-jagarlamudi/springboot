/**
 * 
 */
package com.ragas.boot.rest.exception;

import java.util.Date;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class ExceptionResponse {
	private Date date;
	private String message;
	private String details;

	public ExceptionResponse(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

}
