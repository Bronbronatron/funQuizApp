package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Configuration 
public class QuestionConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(QuestionRepository repository){
		return args -> {
		     List<QuestionChoice> choicesOne = new ArrayList<>();
			 List<QuestionChoice> choicesTwo = new ArrayList<>();
			 List<QuestionChoice> choicesThree = new ArrayList<>();
			 
			 
			 QuestionChoice choiceA = new QuestionChoice("Sushi", ChoiceValue.A);
			 choicesOne.add(choiceA);
			 
			 QuestionChoice choiceB = new QuestionChoice("Ramen", ChoiceValue.B);
			 choicesOne.add(choiceB);
			 
			 QuestionChoice choiceC = new QuestionChoice("Chinese Food", ChoiceValue.C);
			 choicesOne.add(choiceC);
			 
			 
			 
			 QuestionChoice choiceA2 = new QuestionChoice("Tokyo", ChoiceValue.A);
			 choicesTwo.add(choiceA2);
			 
			 QuestionChoice choiceB2 = new QuestionChoice("I'd rather save my money", ChoiceValue.B);
			 choicesTwo.add(choiceB2);
			 
			 QuestionChoice choiceC2 = new QuestionChoice("Orlando", ChoiceValue.C);
			 choicesTwo.add(choiceC2);
	
			 
			 QuestionChoice choiceA3 = new QuestionChoice("Experience as much as possible", ChoiceValue.A);
			 choicesThree.add(choiceA3);
			 
			 QuestionChoice choiceB3 = new QuestionChoice("Don't work more than neccessary", ChoiceValue.B);
			 choicesThree.add(choiceB3);
			 
			 QuestionChoice choiceC3 = new QuestionChoice("Have as much fun as possible", ChoiceValue.C);
			 choicesThree.add(choiceC3);
			

		
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
