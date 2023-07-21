package com.bronwyn.movieRecommendation.questionChoice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.question.QuestionService;

@RestController
@RequestMapping(path = "api/v1/choicevalue")
public class QuestionChoiceController {
	
	
	@Autowired
	private final QuestionChoiceService questionChoiceService ;
	private final QuestionService questionService ;
	
	public QuestionChoiceController(QuestionChoiceService questionChoiceService, QuestionService questionService) {
		this.questionChoiceService = questionChoiceService;
		this.questionService = questionService;
	}
/*
@GetMapping
	public List<QuestionChoice> getQuestion() {
		return questionChoiceService.getQuestionChoice();
	}
*/
	
	@PostMapping
	public void registerNewQuestionChoice(@RequestBody QuestionChoice questionChoice) {
		questionChoiceService.addNewQuestionChoice(null);
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
	
	/*@PutMapping("/{questionChoiceId}/question/{questionId}")
	public void assignQuestionToChoice(@PathVariable Long questionChoiceId, @PathVariable Long questionId) {
	    QuestionChoice questionChoice = questionChoiceService.findQuestionChoiceByID(questionChoiceId)
	            .orElseThrow(() -> new NoSuchElementException("QuestionChoice not found with ID: " + questionChoiceId));
	    Question question = questionService.findQuestionByID(questionId)
	            .orElseThrow(() -> new NoSuchElementException("Question not found with ID: " + questionId));
	    questionChoice.setQuestion(question);
	    questionChoiceService.addNewQuestionChoice(questionChoice);
	   // return questionChoice;
	}*/
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
}



