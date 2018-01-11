/**
 * 
 */
package com.ragas.boot.rest.model;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}
