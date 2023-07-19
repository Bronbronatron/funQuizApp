package com.bronwyn.movieRecommendation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bronwyn.movieRecommendation.formSubmission.FormSubmission;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.question.QuestionService;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Controller
public class MainController {
	
	
	   private final QuestionService questionService;
	    @Autowired
	    public MainController(QuestionService questionService) {
	        this.questionService = questionService;
	    }

	@GetMapping(path = "api/v1/page")
	String getPage(Model model) {
		 List<Question> questions = questionService.getQuestion();
		 model.addAttribute("formSubmission", new FormSubmission(questions));
		return "page";
	}
	
	   @PostMapping(path = "api/v1/page")
	    String processForm(@ModelAttribute("formSubmission") FormSubmission formSubmission) {
	        List<Question> questions = formSubmission.getQuestions();
	        ArrayList<ChoiceValue> answers = new  ArrayList<ChoiceValue>();
	        for (Question question : questions) {
	        	QuestionChoice selectedChoice = question.getSelectedChoice();
	        	ChoiceValue answerValue = selectedChoice.getValue();
	            answers.add(answerValue);
	       
	        }
	        return "result"; 
	    }
	}
	


