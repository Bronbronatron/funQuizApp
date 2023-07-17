package com.bronwyn.movieRecommendation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		return "page";
	}
}