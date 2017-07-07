package com.ragas.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ragas.springboot.domain.Question;
import com.ragas.springboot.domain.Survey;
import com.ragas.springboot.service.SurveyService;

/**
 * @author Chandra Jagarlamudi
 *
 */
@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@GetMapping("/surveys")
	public List<Survey> getAllSurveys() {
		return surveyService.getAllSurveys();
	}

	@GetMapping("/surveys/{surveyId}")
	public Survey getSurvey(@PathVariable final String surveyId) {
		return surveyService.getSurvey(surveyId);
	}

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestions(@PathVariable final String surveyId) {
		return surveyService.getQuestions(surveyId);
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveDetailsForQuestion(@PathVariable final String surveyId,
			@PathVariable final String questionId) {
		return surveyService.getQuestion(surveyId, questionId);
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionToSurvey(@PathVariable final String surveyId,
			@RequestBody final Question newQuestion) {

		Question question = surveyService.addQuestion(surveyId, newQuestion);

		if (question == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
