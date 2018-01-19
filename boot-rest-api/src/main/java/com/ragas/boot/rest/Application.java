package com.ragas.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @EnableResourceServer will turn our application into a resource server
 * (enables Spring Security filter to authenticate requests via an incoming
 * OAuth2 token). 
 * 
 * This secures everything in the server except for the oauth endpoints, 
 * e.g. /oauth/authorize.
 *
 */
@SpringBootApplication
@EnableResourceServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
