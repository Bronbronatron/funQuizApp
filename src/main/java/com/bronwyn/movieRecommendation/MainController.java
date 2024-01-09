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
	
	
	 //  private final QuestionService questionService;
	   private final QuizService quizService;
	   private final PersonalizedMessageService personalizedMessageService;
	   
	    @Autowired
	    public MainController(QuizService quizService, PersonalizedMessageService personalizedMessageService) {
	        this.quizService = quizService;
	        this.personalizedMessageService = personalizedMessageService;
	    }
	    
	    

	  //When a request is sent to a specific URL, the framework looks for a method in the controller that is mapped to that URL. 
	  //The mapping is done using annotations like @RequestMapping, @GetMapping, @PostMapping, etc. 
        @GetMapping(path = "/selection") 
        public String showQuizList(Model model) {
            // Retrieve the list of existing Quiz objects from the service or repository
            List<Quiz> quizzes = quizService.getAllQuizzes();
            // Add the list of quizzes to the model with the key "quizzes"
            model.addAttribute("quizzes", quizzes);
            // Return the name of the Thymeleaf template (quizList.html)
            return "quizList";

	}
        //URI path. Includes a variable placeholder {quizId} enclosed in curly braces. 
        //
        @GetMapping("/quiz/{quizId}")
        public String showQuizById(@PathVariable Long quizId, Model model) {
            // Logic to retrieve questions for the specified quizId
            List<Question> questions = quizService.getQuestionsForQuiz(quizId);
            // Retrieve the Quiz object
            Optional<Quiz> quiz = quizService.findQuizByID(quizId);

            // Check if the Quiz exists, then add it to the model
            quiz.ifPresent(q -> model.addAttribute("quiz", q));

           // Add the questions to the model
           // When you add an attribute to the model in your controller, you're saying, "In my view, I want to access this data, and I'll refer to it using this key."
            model.addAttribute("questions", questions);
            
       
            //If questionChoice is not added to the model, it can still be displayed in the Thymeleaf template, allowing users to make selections.
            //However, when form submitted, server won't automatically receive information about the selected choices
            //unless you explicitly include them in the form data.
            
         // Loop through questions and add their choices to the model
          // if the first question has an ID of 1, the key will be "questionChoices_1", if the second question has an ID of 2, the key will be "questionChoices_2 etc.
            for (Question question : questions) {
                model.addAttribute("questionChoices_" + question.getId(), question.getQuestionChoice());
           }
            
            // Return the name of the Thymeleaf template (showQuiz.html)
            return "showQuiz";
        }
        
        @PostMapping("/submitQuiz")
        public String submitQuiz(Model model, @RequestParam Map<String, String> formData) {
            String findMostCommonChoice = quizService.findMostCommonChoice(formData);
            System.out.println("Form Data: " + formData);
            Long quizId = Long.parseLong(formData.get("quizId"));
            
            Optional<PersonalizedMessage> personalizedMessage = personalizedMessageService.getPersonalizedMessage(findMostCommonChoice, quizId);
            
            // Check if the personalizedMessage is present before adding it to the model
            if (personalizedMessage.isPresent()) {
                model.addAttribute("personalizedMessage", personalizedMessage.get());
            } else {
                // Handle the case where no personalized message is found for the mostCommonChoice
                model.addAttribute("personalizedMessage", "Default Message or handle accordingly");
            }

            return "resultPage";
        }

        
  
        
  

}


	
	

