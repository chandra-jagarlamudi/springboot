package com.ragas.springboot.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ragas.springboot.domain.Lesson;

/**
 * @author Chandra Jagarlamudi
 *
 */
public interface LessonRepository extends CrudRepository<Lesson, String> {
	List<Lesson> findByCourseId(String topicId);

	List<Lesson> findByName(String courseName);

}