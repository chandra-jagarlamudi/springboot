/**
 * 
 */
package com.ragas.boot.rest.model;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Repository
public interface PartyRepository extends CrudRepository<Party, Long> {
	Collection<Party> findAll();
}
