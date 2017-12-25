package com.ragas.boot.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ragas.boot.rest.persistence.model.FilteringBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
@Api(value="REST dynamic filtering example")
public class FilteringController {

	// field1,field2
	@ApiOperation(value = "Get filtered bean", response = FilteringBean.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved filtered bean"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/filtering")
	public MappingJacksonValue getFilteringBean() {
		FilteringBean filteringBean = new FilteringBean("field1", "field2", "field3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filteringBean);
		mapping.setFilters(filters);
		return mapping;
	}

	// field2, field3
	@ApiOperation(value = "Get list of filtered beans", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list of filtered beans"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/filtering-list")
	public MappingJacksonValue getListOfFilteringBeans() {
		List<FilteringBean> list = Arrays.asList(new FilteringBean("field1", "field2", "field3"),
				new FilteringBean("field11", "field22", "field33"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("BeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
