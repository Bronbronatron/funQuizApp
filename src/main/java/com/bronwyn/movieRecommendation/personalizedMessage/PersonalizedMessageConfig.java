package com.bronwyn.movieRecommendation.personalizedMessage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonalizedMessageConfig {

	@Bean
	CommandLineRunner commandLineRunnerMessage(PersonalizedMessageService personalizedMessageService) {
		return args -> {
			
			PersonalizedMessage messageOne = new PersonalizedMessage("Congratulations you're Bron! You're awesome!", AnswerChoice.A);
			PersonalizedMessage messageTwo = new PersonalizedMessage("Congratulations you're Phillip! You're awesome!", AnswerChoice.B);
			PersonalizedMessage messageThree = new PersonalizedMessage("Congratulations you're Chris! You're awesome!", AnswerChoice.C);

			
			personalizedMessageService.addNewPersonalizedMessage(messageOne);
			personalizedMessageService.addNewPersonalizedMessage(messageTwo);
			personalizedMessageService.addNewPersonalizedMessage(messageThree);
		};

	}
	
}