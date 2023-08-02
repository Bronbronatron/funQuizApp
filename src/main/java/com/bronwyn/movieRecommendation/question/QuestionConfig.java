package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoiceRepository;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoiceService;

@Configuration
public class QuestionConfig {
	@Bean
	CommandLineRunner commandLineRunner(QuestionService questionService, QuestionChoiceService choiceService) {
		return args -> {

			Question questionOne = new Question("What's your favourite food?", "Food/Drink");
			Question questionTwo = new Question("What's your favourite holiday destination?", "Free Time");
			Question questionThree = new Question("What life philosophy matches yours best", "Bigger Questions");

			List<QuestionChoice> choicesOne = new ArrayList<>();
			List<QuestionChoice> choicesTwo = new ArrayList<>();
			List<QuestionChoice> choicesThree = new ArrayList<>();

			QuestionChoice choiceA = new QuestionChoice("Sushi", ChoiceValue.A);
			QuestionChoice choiceB = new QuestionChoice("Ramen", ChoiceValue.B);
			QuestionChoice choiceC = new QuestionChoice("Chinese Food", ChoiceValue.C);


			QuestionChoice choiceA2 = new QuestionChoice("Tokyo", ChoiceValue.A);
			QuestionChoice choiceB2 = new QuestionChoice("I'd rather save my money", ChoiceValue.B);
			QuestionChoice choiceC2 = new QuestionChoice("Orlando", ChoiceValue.C);
	

			QuestionChoice choiceA3 = new QuestionChoice("Experience as much as possible", ChoiceValue.A);
			QuestionChoice choiceB3 = new QuestionChoice("Don't work more than neccessary", ChoiceValue.B);
			QuestionChoice choiceC3 = new QuestionChoice("Have as much fun as possible", ChoiceValue.C);
	

			choicesOne.add(choiceA);
			choicesOne.add(choiceB);
			choicesOne.add(choiceC);

			choicesTwo.add(choiceA2);
			choicesTwo.add(choiceB2);
			choicesTwo.add(choiceC2);

			choicesThree.add(choiceA3);
			choicesThree.add(choiceB3);
			choicesThree.add(choiceC3);

			questionOne.setCreatedAt(LocalDateTime.now());
			questionTwo.setCreatedAt(LocalDateTime.now());
			questionThree.setCreatedAt(LocalDateTime.now());
			questionOne.setQuestionChoice(choicesOne);
			questionTwo.setQuestionChoice(choicesTwo);
			questionThree.setQuestionChoice(choicesThree);
			questionService.addNewQuestionWithChoice(questionOne);
			questionService.addNewQuestionWithChoice(questionTwo);
			questionService.addNewQuestionWithChoice(questionThree);
		};
		
	}

}
