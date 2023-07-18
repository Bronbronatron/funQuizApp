package com.bronwyn.movieRecommendation;
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
	        for (Question question : questions) {
	            String selectedChoice = question.getSelectedChoice();
	            // Process the selectedChoice or any other logic you need
	        }
	        return "result"; 
	    }
	}
	


