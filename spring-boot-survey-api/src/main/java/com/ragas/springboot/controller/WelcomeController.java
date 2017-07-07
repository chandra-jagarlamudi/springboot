package com.ragas.springboot.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ragas.springboot.configuration.BasicConfiguration;

/**
 * @author CJ
 *
 */
@RestController
public class WelcomeController {

	@Value("${welcome.message}")
	private String welcomeMessage;

	@Value("${welcome.errorMessage}")
	private String errorMessage;

	@Autowired
	private BasicConfiguration configuration;

	@RequestMapping("/")
	public String welcomeMessage() {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/surveys").build().toUri();
		return welcomeMessage + location.toString();
	}

	@RequestMapping()
	public String errorMessage() {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/surveys").build().toUri();
		return errorMessage + location.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {
		Map map = new HashMap();
		map.put("message", configuration.getMessage());
		map.put("number", configuration.getNumber());
		map.put("value", configuration.isValue());

		return map;
	}

}
