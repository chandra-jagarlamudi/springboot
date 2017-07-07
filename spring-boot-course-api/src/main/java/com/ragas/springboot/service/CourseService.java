package com.ragas.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragas.springboot.domain.Course;

/**
 * @author Chandra Jagarlamudi
 *
 */

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(final String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(final String id) {
		return courseRepository.findOne(id);
	}

	public void createCourse(final Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(final Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(final String id) {
		courseRepository.delete(id);
	}

}