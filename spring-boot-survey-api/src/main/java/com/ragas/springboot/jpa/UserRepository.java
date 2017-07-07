package com.ragas.springboot.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ragas.springboot.domain.User;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByRole(String role);
}
