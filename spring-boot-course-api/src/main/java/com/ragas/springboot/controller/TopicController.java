package com.ragas.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.springboot.domain.Topic;
import com.ragas.springboot.service.TopicService;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}")
	public Topic getTopic(@PathVariable final String topicId) {
		return topicService.getTopic(topicId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void createTopic(@RequestBody final Topic topic) {
		topicService.createTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}")
	public void updateTopic(@RequestBody final Topic topic, @PathVariable final String topicId) {
		topicService.updateTopic(topicId, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable final String topicId) {
		topicService.deleteTopic(topicId);
	}

}
