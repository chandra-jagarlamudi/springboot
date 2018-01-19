/**
 * 
 */
package com.ragas.boot.rest.security;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}
