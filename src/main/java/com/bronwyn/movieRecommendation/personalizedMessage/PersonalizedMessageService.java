package com.bronwyn.movieRecommendation.personalizedMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.formSubmission.PersonalizedMessageUpdateForm;
import com.bronwyn.movieRecommendation.quiz.Quiz;
import com.bronwyn.movieRecommendation.quiz.QuizRepository;

@Service
public class PersonalizedMessageService {

	private final PersonalizedMessageRepository personalizedMessageRepository;
	private final QuizRepository quizRepository;

	@Autowired
	public PersonalizedMessageService(PersonalizedMessageRepository personalizedMessageRepository, QuizRepository quizRepository) {
		this.personalizedMessageRepository = personalizedMessageRepository;
		this.quizRepository = quizRepository;
	}
	
	@Transactional(readOnly = true)
	public List<PersonalizedMessage> getAllPersonalizedMessage() {
	    return personalizedMessageRepository.findAll();
	}

	@Transactional
	public void addNewPersonalizedMessage(Long quizId, PersonalizedMessage personalizedMessage) {
		Quiz quiz = quizRepository.findById(quizId)
				.orElseThrow(() -> new IllegalStateException("Quiz with Id " + quizId + " does not exist"));
		personalizedMessage.setQuiz(quiz);
		personalizedMessageRepository.save(personalizedMessage);
	}
	

	@Transactional
	public void deletePersonalizedMessage(Long personalizedMessageId) {
		boolean exists = personalizedMessageRepository.existsById(personalizedMessageId);
		if (!exists) {
			throw new IllegalStateException("Personalized Message" + personalizedMessageId + " does not exist");
		}
		personalizedMessageRepository.deleteById(personalizedMessageId);
	}

	@Transactional
	public void updatePersonalizedMessageUsingForm(Long personalizedMessageId,
			PersonalizedMessageUpdateForm personalizedMessageUpdateForm) {
		PersonalizedMessage personalizedMessage = personalizedMessageRepository.findById(personalizedMessageId)
				.orElseThrow(() -> new IllegalStateException(
						"Question with Id " + personalizedMessageId + " does not exist"));

		String updatedMessage = personalizedMessageUpdateForm.getMessage();
		if (updatedMessage != null) {
			personalizedMessage.setMessage(updatedMessage);
		}

		AnswerChoice updatedAnswerChoice = personalizedMessageUpdateForm.getAnswerChoice();
		if (updatedAnswerChoice != null) {
			personalizedMessage.setAnswerChoice(updatedAnswerChoice);
		}
		personalizedMessageRepository.save(personalizedMessage);

	}



}
