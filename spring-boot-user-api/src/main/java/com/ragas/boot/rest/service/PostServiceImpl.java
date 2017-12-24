package com.ragas.boot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ragas.boot.rest.persistence.model.Post;
import com.ragas.boot.rest.persistence.repository.PostRepository;

/**
 * @author Chandra Jagarlamudi
 *
 */
@Component
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public void save(Post post) {
		postRepository.save(post);
	}

}
