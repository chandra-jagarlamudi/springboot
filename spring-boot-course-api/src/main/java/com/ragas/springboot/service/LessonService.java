package com.ragas.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragas.springboot.domain.Lesson;

/**
 * @author Chandra Jagarlamudi
 *
 */

@Service
public class LessonService {
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getLessons(final String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}

	public Lesson getLesson(final String id) {
		return lessonRepository.findOne(id);
	}

	public void createLesson(final Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(final Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void deleteLesson(final String id) {
		lessonRepository.delete(id);
	}

}