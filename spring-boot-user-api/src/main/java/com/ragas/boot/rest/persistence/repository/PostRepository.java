package com.ragas.boot.rest.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ragas.boot.rest.persistence.model.Post;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
