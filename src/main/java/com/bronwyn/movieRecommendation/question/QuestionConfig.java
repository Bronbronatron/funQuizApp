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
			 List<String> choicesThree = new ArrayList<>();
			 choicesOne.add("Sushi");
			 choicesOne.add("Ramen");
			 choicesOne.add("Chinese Food");
			 choicesTwo.add("Tokyo");
			 choicesTwo.add("I'd rather save my money");
			 choicesTwo.add("Orlando");
			 choicesThree.add("Experience as much as possible");
			 choicesThree.add("Don't work more than neccessary");
			 choicesThree.add("Have as much fun as possible");
			Question questionOne = new Question("What's your favourite food?", "Food/Drink", choicesOne);
			Question questionTwo = new Question("What's your favourite holiday destination?", "Free Time", choicesTwo);
			Question questionThree = new Question("What life philosophy matches yours best", "Bigger Questions", choicesThree);
			 List<Question> questions = new ArrayList<>();
	            questions.add(questionOne);
	            questions.add(questionTwo);
	            questions.add(questionThree);
	        	questionOne.setCreatedAt(LocalDateTime.now());
	        	questionTwo.setCreatedAt(LocalDateTime.now());
	        	questionThree.setCreatedAt(LocalDateTime.now());
			repository.saveAll(questions );
		};
	}
	

}
