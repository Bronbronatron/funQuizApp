package com.bronwyn.movieRecommendation.question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bronwyn.movieRecommendation.formSubmission.QuestionUpdateForm;

@RestController
@RequestMapping(path = "api/v1/question")
public class QuestionController {

	@Autowired
	private final QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@GetMapping
	public List<Question> getQuestion() {
		return questionService.getQuestion();
	}
	
	@GetMapping("/{questionId}")
	public Optional<Question> findQuestionByID(@PathVariable Long questionId) {
		return questionService.findQuestionByID(questionId);
	}



	@PostMapping("{quizId}")
	public void registerNewQuestion(@PathVariable Long quizId, @RequestBody Question question) {
		questionService.addNewQuestionWithChoice(quizId, question);
	}
	
	@DeleteMapping(path = "{questionId}")
	public void deleteQuestion(@PathVariable("questionId") Long questionId) {
		questionService.deleteQuestion(questionId);
	}
	
	
	 @PutMapping("{questionId}")
	    public void updateQuestion(@PathVariable Long questionId, @RequestBody QuestionUpdateForm questionUpdateForm) {
	        questionService.updateQuestionUsingForm(questionId, questionUpdateForm);
	    }
}