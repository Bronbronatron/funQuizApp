package com.bronwyn.movieRecommendation.quiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.personalizedMessage.AnswerChoice;
import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Configuration
public class QuizConfig {
	/*		
	@Bean
	@Transactional 
	CommandLineRunner commandLineRunner(QuizService quizService) {
		return args -> {
			
		
			Quiz QuizOne = new Quiz("Family Quiz");
			
			List<PersonalizedMessage> personalizedMessageOne = new ArrayList<>();
			
			PersonalizedMessage messageOne = new PersonalizedMessage("Congratulations you're Bron! You're awesome!", AnswerChoice.A);
			PersonalizedMessage messageTwo = new PersonalizedMessage("Congratulations you're Phillip! You're awesome!", AnswerChoice.B);
			PersonalizedMessage messageThree = new PersonalizedMessage("Congratulations you're Chris! You're awesome!", AnswerChoice.C);
			PersonalizedMessage messageFour = new PersonalizedMessage("Congratulations you're Phyllis! You're awesome!",  AnswerChoice.D);

			
			personalizedMessageOne.add(messageOne);
			personalizedMessageOne.add(messageTwo);
			personalizedMessageOne.add(messageThree);
			personalizedMessageOne.add(messageFour);
			
			
			Question questionOne = new Question("What's your favourite food?");
			Question questionTwo = new Question("What's your favourite holiday destination?");
			Question questionThree = new Question("What life philosophy matches yours best?");

			List<QuestionChoice> choicesOne = new ArrayList<>();
			List<QuestionChoice> choicesTwo = new ArrayList<>();
			List<QuestionChoice> choicesThree = new ArrayList<>();

			QuestionChoice choiceA = new QuestionChoice("Sushi", ChoiceValue.A);
	
			QuestionChoice choiceB = new QuestionChoice("Ramen", ChoiceValue.B);
		
			QuestionChoice choiceC = new QuestionChoice("Chinese Food", ChoiceValue.C);
			
			QuestionChoice choiceD = new QuestionChoice("Authentic Italian Pizza", ChoiceValue.D);
	

			QuestionChoice choiceA2 = new QuestionChoice("Tokyo", ChoiceValue.A);
		
			QuestionChoice choiceB2 = new QuestionChoice("I'd rather save my money", ChoiceValue.B);

			QuestionChoice choiceC2 = new QuestionChoice("Orlando", ChoiceValue.C);
			
			QuestionChoice choiceD2 = new QuestionChoice("Venice", ChoiceValue.D);


			QuestionChoice choiceA3 = new QuestionChoice("Experience as much as possible", ChoiceValue.A);
		
			QuestionChoice choiceB3 = new QuestionChoice("Don't work more than neccessary", ChoiceValue.B);
		
			QuestionChoice choiceC3 = new QuestionChoice("Have as much fun as possible", ChoiceValue.C);
			
			QuestionChoice choiceD3 = new QuestionChoice("Use your talents to do little things to make the world a better place", ChoiceValue.D);
		
			choicesOne.add(choiceA);
			choicesOne.add(choiceB);
			choicesOne.add(choiceC);
			choicesOne.add(choiceD);

			choicesTwo.add(choiceA2);
			choicesTwo.add(choiceB2);
			choicesTwo.add(choiceC2);
			choicesTwo.add(choiceD2);
			
			choicesThree.add(choiceA3);
			choicesThree.add(choiceB3);
			choicesThree.add(choiceC3);
			choicesThree.add(choiceD3);

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
			QuizOne.setPersonalizedMessage(personalizedMessageOne);
			quizService.addNewQuizWithQuestion(QuizOne);
			
			
			
			
			
			
			
Quiz QuizOneAnimal = new Quiz("Animal Quiz");
			
			List<PersonalizedMessage> AnimalpersonalizedMessageOne = new ArrayList<>();
			
			PersonalizedMessage AnimalmessageOne = new PersonalizedMessage("Congratulations you're a dog! You're awesome!", AnswerChoice.A);
			PersonalizedMessage AnimalmessageTwo = new PersonalizedMessage("Congratulations you're a cat! You're awesome!", AnswerChoice.B);
			PersonalizedMessage AnimalmessageThree = new PersonalizedMessage("Congratulations you're a rabbit! You're awesome!", AnswerChoice.C);

			
			AnimalpersonalizedMessageOne.add(AnimalmessageOne);
			AnimalpersonalizedMessageOne.add(AnimalmessageTwo);
			AnimalpersonalizedMessageOne.add(AnimalmessageThree);
			
			
			Question AnimalquestionOne = new Question("What would you like to find in your bowl?");
			Question AnimalquestionTwo = new Question("What's your favourite kind of place to go?");
			Question AnimalquestionThree = new Question("How do you think everyone should live their lives?");

			List<QuestionChoice> AnimalchoicesOne = new ArrayList<>();
			List<QuestionChoice> AnimalchoicesTwo = new ArrayList<>();
			List<QuestionChoice> AnimalchoicesThree = new ArrayList<>();

			QuestionChoice AnimalchoiceA = new QuestionChoice("Steak", ChoiceValue.A);
	
			QuestionChoice AnimalchoiceB = new QuestionChoice("Grilled fish", ChoiceValue.B);
		
			QuestionChoice AnimalchoiceC = new QuestionChoice("Something vegeterian", ChoiceValue.C);
	

			QuestionChoice AnimalchoiceA2 = new QuestionChoice("Somewhere with wide open spaces and outdoor activites", ChoiceValue.A);
		
			QuestionChoice AnimalchoiceB2 = new QuestionChoice("Somwhere I can be alone", ChoiceValue.B);

			QuestionChoice AnimalchoiceC2 = new QuestionChoice("Anywhere with my friends/family", ChoiceValue.C);


			QuestionChoice AnimalchoiceA3 = new QuestionChoice("Relax and have fun!", ChoiceValue.A);
		
			QuestionChoice AnimalchoiceB3 = new QuestionChoice("Be the boss!", ChoiceValue.B);
		
			QuestionChoice AnimalchoiceC3 = new QuestionChoice("Hug the ones you love!", ChoiceValue.C);
		
			AnimalchoicesOne.add(AnimalchoiceA);
			AnimalchoicesOne.add(AnimalchoiceB);
			AnimalchoicesOne.add(AnimalchoiceC);

			AnimalchoicesTwo.add(AnimalchoiceA2);
			AnimalchoicesTwo.add(AnimalchoiceB2);
			AnimalchoicesTwo.add(AnimalchoiceC2);

			AnimalchoicesThree.add(AnimalchoiceA3);
			AnimalchoicesThree.add(AnimalchoiceB3);
			AnimalchoicesThree.add(AnimalchoiceC3);

			AnimalquestionOne.setCreatedAt(LocalDateTime.now());
			AnimalquestionTwo.setCreatedAt(LocalDateTime.now());
			AnimalquestionThree.setCreatedAt(LocalDateTime.now());
			
			AnimalquestionOne.setQuestionChoice(AnimalchoicesOne);
			AnimalquestionTwo.setQuestionChoice(AnimalchoicesTwo);
			AnimalquestionThree.setQuestionChoice(AnimalchoicesThree);

			
			List<Question> AnimalquizListOne = new ArrayList<>();
			AnimalquizListOne.add(AnimalquestionOne);
			AnimalquizListOne.add(AnimalquestionTwo);
			AnimalquizListOne.add(AnimalquestionThree);
			
			
			QuizOneAnimal.setCreatedAt(LocalDateTime.now());
			QuizOneAnimal.setQuizQuestion(AnimalquizListOne);
			QuizOneAnimal.setPersonalizedMessage(AnimalpersonalizedMessageOne);
			quizService.addNewQuizWithQuestion(QuizOneAnimal);
			
				
		};
	
	}
	
	*/
}
		