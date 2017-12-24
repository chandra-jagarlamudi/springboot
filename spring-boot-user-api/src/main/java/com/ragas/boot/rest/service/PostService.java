package com.ragas.boot.rest.service;

import org.springframework.stereotype.Service;

import com.ragas.boot.rest.persistence.model.Post;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Service
public interface PostService {

	void save(Post post);

}
