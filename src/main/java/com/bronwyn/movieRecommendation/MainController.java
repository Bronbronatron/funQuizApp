package com.bronwyn.movieRecommendation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bronwyn.movieRecommendation.question.QuestionService;
import com.bronwyn.movieRecommendation.quiz.QuizService;
import com.bronwyn.movieRecommendation.quiz.Quiz;


@Controller
public class MainController {
	
	
	 //  private final QuestionService questionService;
	   private final QuizService quizService;
	   
	    @Autowired
	    public MainController(QuizService quizService) {
	        this.quizService = quizService;
	    }

        @GetMapping(path = "/api/v1/selection") 
        public String showQuizList(Model model) {
            // Retrieve the list of existing Quiz objects from the service or repository
            List<Quiz> quizzes = quizService.getAllQuizzes();
            // Add the list of quizzes to the model with the key "quizzes"
            model.addAttribute("quizzes", quizzes);
            // Return the name of the Thymeleaf template (quizList.html)
            return "quizList";

	}
}


	
	

