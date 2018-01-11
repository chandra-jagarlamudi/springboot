/**
 * 
 */
package com.ragas.boot.rest.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
