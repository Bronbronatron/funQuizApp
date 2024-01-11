package com.bronwyn.movieRecommendation;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessageService;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.quiz.Quiz;
import com.bronwyn.movieRecommendation.quiz.QuizService;


@Controller
@RequestMapping("/api/v1/main")
public class MainController {

	    
	    @GetMapping(path = "/home")
	    public String showHomeScreen() {
	    	
	    	return "homeScreen";
	    }
	    
	    @GetMapping(path = "/createQuiz")
	    public String showQuizFrom() {
	    	
	    	return "quizForm";
	    }
	        
 
}


	
	

