/**
 * 
 */
package com.ragas.boot.rest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
@Api(value="User Management")
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource; 

	@ApiOperation(value = "A simple Hello World example", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved String"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@ApiOperation(value = "A simple Hello World example showing internationalization", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved String"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
}
