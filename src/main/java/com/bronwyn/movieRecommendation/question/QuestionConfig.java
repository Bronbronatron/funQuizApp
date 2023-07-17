package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class QuestionConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(QuestionRepository repository){
		return args -> {
		     List<String> choicesOne = new ArrayList<>();
			 List<String> choicesTwo = new ArrayList<>();
			 choicesOne.add("Sushi");
			 choicesOne.add("Ramen");
			 choicesOne.add("Chinese Food");
			 choicesTwo.add("Tokyo");
			 choicesTwo.add("I'd rather save my money");
			 choicesTwo.add("Orlando");
			Question questionOne = new Question("What's your favourite food?", "Food/Drink", choicesOne);
			Question questionTwo = new Question("What's your favourite holiday destination?", "Free Time", choicesTwo);
			 List<Question> questions = new ArrayList<>();
	            questions.add(questionOne);
	            questions.add(questionTwo);
	        	questionOne.setCreatedAt(LocalDateTime.now());
	        	questionTwo.setCreatedAt(LocalDateTime.now());
			repository.saveAll(questions );
		};
	}
	

}
