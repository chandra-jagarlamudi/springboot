package com.ragas.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragas.springboot.domain.Topic;

/**
 * @author Chandra Jagarlamudi
 *
 */

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(final String id) {
		return topicRepository.findById(id);
	}

	public void createTopic(final Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(final String id, final Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(final String id) {
		topicRepository.deleteById(id);
	}

}