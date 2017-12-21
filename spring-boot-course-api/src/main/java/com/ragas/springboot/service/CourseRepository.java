package com.ragas.springboot.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ragas.springboot.domain.Course;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface CourseRepository extends CrudRepository<Course, String> {
	
	List<Course> findByTopicId(String topicId);
	List<Course> findByName(String courseName);

}