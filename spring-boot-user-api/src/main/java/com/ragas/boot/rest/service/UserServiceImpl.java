/**
 * 
 */
package com.ragas.boot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ragas.boot.rest.persistence.model.User;
import com.ragas.boot.rest.persistence.repository.UserRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findOne(int id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean deleteUser(int id) {
		return false;
	}

}
