package com.bronwyn.movieRecommendation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	        model.addAttribute("questions", questions);
	        model.addAttribute("question", new Question());
		return "page";
	}
	
	   @PostMapping(path = "api/v1/page")
	    String processForm(@ModelAttribute List<Question> questions) {
	        for (Question question : questions) {
	            String selectedChoice = question.getSelectedChoice();
	        }
	        return "redirect:/result"; // Change "/result" to the appropriate URL for the result page
	    }
	}


