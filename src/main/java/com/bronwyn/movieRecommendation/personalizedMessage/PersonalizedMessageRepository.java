package com.bronwyn.movieRecommendation.personalizedMessage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonalizedMessageRepository extends JpaRepository<PersonalizedMessage, Long> {
	

    Optional<PersonalizedMessage> findPersonalizedMessageByAnswerChoiceAndQuizId(AnswerChoice answerChoice, Long quizId);


}
