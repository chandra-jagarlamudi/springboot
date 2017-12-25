package com.ragas.boot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.boot.rest.persistence.model.Name;
import com.ragas.boot.rest.persistence.model.PersonV1;
import com.ragas.boot.rest.persistence.model.PersonV2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Chandra Jagarlamudi
 *
 */

@RestController
@Api(value="REST versioning example, lists different types of versioning")
public class VersioningController {

	@ApiOperation(value = "This is URI versioning, returning V1 of Person", response = PersonV1.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V1 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Chandra Jagarlamudi");
	}

	@ApiOperation(value = "This is URI versioning, returning V2 of Person", response = PersonV2.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V2 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Abhiram", "Jagarlamudi"));
	}

	@ApiOperation(value = "This is versioning based on Request Parameter returning V1 of Person", response = PersonV1.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V1 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Chandra Jagarlamudi");
	}

	@ApiOperation(value = "This is versioning based on Request Parameter returning V2 of Person", response = PersonV2.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V2 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Abhiram", "Jagarlamudi"));
	}

	@ApiOperation(value = "This is versioning based on Custom HEADERS returning V1 of Person", response = PersonV1.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V1 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Chandra Jagarlamudi");
	}

	@ApiOperation(value = "This is versioning based on Custom HEADERS returning V2 of Person", response = PersonV2.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V2 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Abhiram", "Jagarlamudi"));
	}

	@ApiOperation(value = "This is versioning based on Media type returning V1 of Person", response = PersonV1.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V1 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Chandra Jagarlamudi");
	}

	@ApiOperation(value = "This is versioning based on Media type returning V2 of Person", response = PersonV2.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved V2 Person object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Abhiram", "Jagarlamudi"));
	}

}
