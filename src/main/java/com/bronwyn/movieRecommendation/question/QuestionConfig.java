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
			
			Question questionOne = new Question("What's your favourite food?", "Food/Drink");
			Question questionTwo = new Question("What's your favourite Meal?", "Food/Drink");
			 List<Question> questions = new ArrayList<>();
	            questions.add(questionOne);
	            questions.add(questionTwo);
	        	questionOne.setCreatedAt(LocalDateTime.now());
	        	questionTwo.setCreatedAt(LocalDateTime.now());
			repository.saveAll(questions );
		};
	}
	

}
