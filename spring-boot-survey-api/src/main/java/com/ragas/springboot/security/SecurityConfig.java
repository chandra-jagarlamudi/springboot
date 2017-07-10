package com.ragas.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Authentication : User --> Roles
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("secret").roles("USER").and().withUser("admin")
		.password("secret").roles("USER", "ADMIN");
	}

	// Authorization : Role -> Access
	// survey -> USER
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/webapi/v1/surveys/**").hasRole("USER")
		.antMatchers("/webapi/v1/users/**").hasRole("USER").antMatchers("/webapi/v1/**").hasRole("ADMIN").and()
		.csrf().disable().headers().frameOptions()
		.disable();
	}

}
