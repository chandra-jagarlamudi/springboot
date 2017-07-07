package com.ragas.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.springboot.domain.Course;
import com.ragas.springboot.domain.Lesson;
import com.ragas.springboot.service.LessonService;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getLessons(@PathVariable final String courseId) {
		return lessonService.getLessons(courseId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable final String lessonId) {
		return lessonService.getLesson(lessonId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
	public void createLesson(@RequestBody final Lesson lesson, @PathVariable final String topicId,
			@PathVariable final String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.createLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@RequestBody final Lesson lesson, @PathVariable final String topicId,
			@PathVariable final String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.updateLesson(lesson);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteCourse(@PathVariable final String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
}
