package com.bronwyn.movieRecommendation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bronwyn.movieRecommendation.question.Question;
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
        
        @GetMapping("/quiz/{quizId}")
        public String showQuizById(@PathVariable Long quizId, Model model) {
            // Logic to retrieve questions for the specified quizId
            List<Question> questions = quizService.getQuestionsForQuiz(quizId);
            // Retrieve the Quiz object
            Optional<Quiz> quiz = quizService.findQuizByID(quizId);

            // Check if the Quiz exists, then add it to the model
            quiz.ifPresent(q -> model.addAttribute("quiz", q));

            // Add the questions to the model
            model.addAttribute("questions", questions);
            
            // Return the name of the Thymeleaf template (showQuiz.html)
            return "showQuiz";
        }

}


	
	

