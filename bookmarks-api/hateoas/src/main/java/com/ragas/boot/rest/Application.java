package com.ragas.boot.rest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ragas.boot.rest.model.Account;
import com.ragas.boot.rest.model.AccountRepository;
import com.ragas.boot.rest.model.Bookmark;
import com.ragas.boot.rest.model.BookmarkRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList("chandra,abhiram,lasya,lavanya,larry,gary,shaun".split(",")).forEach(a -> {
			Account account = accountRepository.save(new Account(a, "password"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A description"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A description"));
		});
	}
}