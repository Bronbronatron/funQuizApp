package com.bronwyn.movieRecommendation.personalizedMessage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bronwyn.movieRecommendation.formSubmission.PersonalizedMessageUpdateForm;
import com.bronwyn.movieRecommendation.formSubmission.QuestionChoiceUpdateForm;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Service
public class PersonalizedMessageService {

	private final PersonalizedMessageRepository personalizedMessageRepository;

	@Autowired
	public PersonalizedMessageService(PersonalizedMessageRepository personalizedMessageRepository) {
		this.personalizedMessageRepository = personalizedMessageRepository;
	}

	@Transactional
	public void addNewPersonalizedMessage(PersonalizedMessage personalizedMessage) {
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
