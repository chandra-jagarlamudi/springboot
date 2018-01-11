/**
 * 
 */
package com.ragas.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ragas.boot.rest.model.AccountRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return (username) -> accountRepository.findByUsername(username)
				.map(a -> new User(a.username, a.password, true, true, true, true,
						AuthorityUtils.createAuthorityList("USER", "write")))
				.orElseThrow(() -> new UsernameNotFoundException("Could not find the user '" + username + "'"));
	}
}
