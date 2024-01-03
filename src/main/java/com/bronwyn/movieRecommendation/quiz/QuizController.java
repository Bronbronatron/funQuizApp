package com.bronwyn.movieRecommendation.quiz;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/quiz")
public class QuizController {

	@Autowired
	private final QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@GetMapping("/{quizId}")
	public Optional<Quiz> findQuestionByID(@PathVariable Long quizId) {
		return quizService.findQuizByID(quizId);
	}

	@PostMapping
	public void registerNewQuiz(@RequestBody Quiz quiz) {
		quizService.addNewQuizWithQuestion(quiz);
	}

	@DeleteMapping(path = "{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		quizService.deleteQuiz(quizId);
	}

}
