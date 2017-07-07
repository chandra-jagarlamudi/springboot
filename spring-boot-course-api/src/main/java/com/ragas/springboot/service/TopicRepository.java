package com.ragas.springboot.service;

import org.springframework.data.repository.CrudRepository;

import com.ragas.springboot.domain.Topic;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface TopicRepository extends CrudRepository<Topic, String> {

}