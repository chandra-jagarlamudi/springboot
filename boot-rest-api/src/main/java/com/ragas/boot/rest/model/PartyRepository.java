/**
 * 
 */
package com.ragas.boot.rest.model;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RepositoryRestResource(collectionResourceRel = "party", path = "parties")
public interface PartyRepository extends PagingAndSortingRepository<Party, Long> {
	Collection<Party> findAll();
}
