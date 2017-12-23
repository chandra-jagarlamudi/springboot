/**
 * 
 */
package com.ragas.boot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ragas.boot.rest.persistence.model.User;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Service
public interface UserService {
	List<User> findAll();
	User save(User user);
	Optional<User> findOne(int id);
	boolean deleteUser(int id);
}
