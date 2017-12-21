package com.ragas.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.springboot.domain.Course;
import com.ragas.springboot.domain.Topic;
import com.ragas.springboot.service.CourseService;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable final String topicId) {
		return courseService.getCourses(topicId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable final String courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void createCourse(@RequestBody final Course course, @PathVariable final String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.createCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody final Course course, @PathVariable final String topicId,
			@PathVariable final String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable final String courseId) {
		courseService.deleteCourse(courseId);
	}
}
