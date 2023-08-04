package com.bronwyn.movieRecommendation.questionChoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bronwyn.movieRecommendation.formSubmission.QuestionChoiceUpdateForm;

@RestController
@RequestMapping(path = "api/v1/questionChoice")
public class QuestionChoiceController {
	
	
	@Autowired
	private final QuestionChoiceService questionChoiceService ;

	public QuestionChoiceController(QuestionChoiceService questionChoiceService) {
		this.questionChoiceService = questionChoiceService;
	}


	@PostMapping("{questionId}")
	public void addNewQuestionChoice(@PathVariable Long questionId, @RequestBody QuestionChoice questionChoice) {
	    questionChoiceService.addNewQuestionChoice(questionId, questionChoice);
	}


	@DeleteMapping(path = "{questionChoiceId}")
	public void deleteQuestionChoice(@PathVariable("questionChoiceId") Long questionChoiceId) {
		questionChoiceService.deleteQuestionChoice(questionChoiceId);
	}

	
	@GetMapping
	public List<QuestionChoice> getAllQuestion() {
		return questionChoiceService.getAllQuestionChoices();
	}
	
	
	 @PutMapping("{questionChoiceId}")
	    public void updateQuestion(@PathVariable Long questionChoiceId, @RequestBody QuestionChoiceUpdateForm questionChoiceUpdateForm) {
	        questionChoiceService.updateQuestionChoiceUsingForm(questionChoiceId, questionChoiceUpdateForm);
	    }
	
}



