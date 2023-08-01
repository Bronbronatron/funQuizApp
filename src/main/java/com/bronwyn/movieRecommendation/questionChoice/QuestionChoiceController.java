package com.bronwyn.movieRecommendation.questionChoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/choicevalue")
public class QuestionChoiceController {
	
	
	@Autowired
	private final QuestionChoiceService questionChoiceService ;

	public QuestionChoiceController(QuestionChoiceService questionChoiceService) {
		this.questionChoiceService = questionChoiceService;
	}

	
	@PostMapping
	public void registerNewQuestionChoice(@RequestBody QuestionChoice questionChoice) {
		questionChoiceService.addNewQuestionChoice(questionChoice);
	}

	@DeleteMapping(path = "{questionChoiceId}")
	public void deleteQuestionChoice(@PathVariable("questionChoiceId") Long questionChoiceId) {
		questionChoiceService.deleteQuestionChoice(questionChoiceId);
	}

	@PutMapping(path = "{questionId}")
	public void updateQuestionChoice(@PathVariable("questionChoiceId") Long questionChoiceId,
			@RequestParam(required = false) String choicePrompt, @RequestParam(required = false) ChoiceValue value) {
		questionChoiceService.updateQuestionChoice(questionChoiceId, choicePrompt, value);
	}
	

}



