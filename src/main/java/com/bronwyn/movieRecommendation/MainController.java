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

import com.bronwyn.movieRecommendation.choiceProcessorService.ChoiceProcessorService;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.quiz.Quiz;
import com.bronwyn.movieRecommendation.quiz.QuizService;


@Controller
@RequestMapping("/api/v1/main")
public class MainController {
	
	
	 //  private final QuestionService questionService;
	   private final QuizService quizService;
	   private final ChoiceProcessorService choiceProcessorService;
	   
	    @Autowired
	    public MainController(QuizService quizService, ChoiceProcessorService choiceProcessorService) {
	        this.quizService = quizService;
	        this.choiceProcessorService = choiceProcessorService;
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
        //@RequestParam Map<String, String> formData indicates that it expects form data as key-value pairs. 
        //f you have multiple radio buttons, formData map will contain entries for each of these selections.
         public String submitQuiz(@RequestParam Map<String, String> formData) {
       	// Process the form data
       	  
       	  //formData is not directly iterable in the enhanced for loop.
       	  //This is because formData is of type Map, and a Map is not directly iterable
       	  //To iterate over a Map, you typically use either keySet() or entrySet() methods.
        	
        	String[] mapAsString = new String[formData.size()];
        	int index = 0;
        	
             for (Map.Entry<String, String> entry : formData.entrySet()) {
           	//For each individual entry in formData:
                 String fieldName = entry.getKey();
                 String value = entry.getValue();
                 mapAsString[index++] = value;
                 System.out.println("Field: " + fieldName + ", Value: " + value);
             }
             
             
             String mostCommonChoice = choiceProcessorService.findMostCommonString(mapAsString);
             System.out.println("Most common Choice: " + mostCommonChoice);
             
             return "resultPage";
         }

        
        
        
         // Each radio button is associated with a specific question, and it has a name and value set by Thymeleaf attributes. 
         //When the user submits the form, the browser sends the data to the server as part of the request. 
        // For radio buttons, only the selected value is sent.
        
  

}


	
	

