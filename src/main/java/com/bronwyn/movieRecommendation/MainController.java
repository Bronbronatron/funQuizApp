package com.bronwyn.movieRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	//	 List<Question> questions = questionService.getQuestion();
	//	 model.addAttribute("formSubmission", new FormSubmission(questions));
		return "page";
	}
	
	 /*  @PostMapping(path = "api/v1/page")
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
	    
	    */
	}
	


