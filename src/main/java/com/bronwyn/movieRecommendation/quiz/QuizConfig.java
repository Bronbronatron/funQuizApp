package com.bronwyn.movieRecommendation.quiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Configuration
public class QuizConfig {
	
	@Bean
	@Transactional 
	CommandLineRunner commandLineRunner(QuizService quizService) {
		return args -> {
			
			
			Quiz QuizOne = new Quiz("Family Quiz");
			
			
			Question questionOne = new Question("What's your favourite food?", "Food/Drink");
			Question questionTwo = new Question("What's your favourite holiday destination?", "Free Time");
			Question questionThree = new Question("What life philosophy matches yours best", "Bigger Questions");

			List<QuestionChoice> choicesOne = new ArrayList<>();
			List<QuestionChoice> choicesTwo = new ArrayList<>();
			List<QuestionChoice> choicesThree = new ArrayList<>();

			QuestionChoice choiceA = new QuestionChoice("Sushi", ChoiceValue.A);
		//	choiceA.setQuestion(questionOne);
			QuestionChoice choiceB = new QuestionChoice("Ramen", ChoiceValue.B);
		//	choiceB.setQuestion(questionOne);
			QuestionChoice choiceC = new QuestionChoice("Chinese Food", ChoiceValue.C);
		//	choiceC.setQuestion(questionOne);

			QuestionChoice choiceA2 = new QuestionChoice("Tokyo", ChoiceValue.A);
		//	choiceA2.setQuestion(questionTwo);
			QuestionChoice choiceB2 = new QuestionChoice("I'd rather save my money", ChoiceValue.B);
		//	choiceB2.setQuestion(questionTwo);
			QuestionChoice choiceC2 = new QuestionChoice("Orlando", ChoiceValue.C);
		//	choiceC2.setQuestion(questionTwo);

			QuestionChoice choiceA3 = new QuestionChoice("Experience as much as possible", ChoiceValue.A);
		//	choiceA3.setQuestion(questionThree);
			QuestionChoice choiceB3 = new QuestionChoice("Don't work more than neccessary", ChoiceValue.B);
		//	choiceB3.setQuestion(questionThree);
			QuestionChoice choiceC3 = new QuestionChoice("Have as much fun as possible", ChoiceValue.C);
		//	choiceC3.setQuestion(questionThree);

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

			
			List<Question> quizListOne = new ArrayList<>();
			quizListOne.add(questionOne);
			quizListOne.add(questionTwo);
			quizListOne.add(questionThree);
			
			
			QuizOne.setCreatedAt(LocalDateTime.now());
			QuizOne.setQuizQuestion(quizListOne);
			quizService.addNewQuizWithQuestion(QuizOne);
				
		};
	
	}

}
			