package com.bronwyn.movieRecommendation.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

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


	@PostMapping
	public void registerNewQuestion(@RequestBody Question question) {
		questionService.addNewQuestionWithChoice(question);
	}

	@DeleteMapping(path = "{questionId}")
	public void deleteQuestion(@PathVariable("questionId") Long questionId) {
		questionService.deleteQuestion(questionId);
	}
	
	
/*
    @PostMapping("/questions")
    public ResponseEntity<String> saveQuestionWithChoices(@RequestBody QuestionWithChoicesDTO dto) {
        // Create the Question object
        Question question = new Question();
        question.setPrompt(dto.getQuestionPrompt());

        // Create the QuestionChoice objects
        List<QuestionChoice> choices = new ArrayList<>();
        for (String choicePrompt : dto.getChoicePrompts()) {
            QuestionChoice choice = new QuestionChoice();
            choice.setChoicePrompt(choicePrompt);
            choices.add(choice);
        }

        // Save the Question with associated choices
        questionService.saveQuestionWithChoices(question, choices);

        return ResponseEntity.ok("Question and Choices saved successfully.");
    }

*/
	@PutMapping(path = "{questionId}")
	public void updateQuestion(@PathVariable("questionId") Long questionId,
			@RequestParam(required = false) String prompt, @RequestParam(required = false) String topic) {
		questionService.updateQuestion(questionId, prompt, topic);
	}
	

	

}
