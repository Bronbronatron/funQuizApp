package com.bronwyn.movieRecommendation.personalizedMessage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if(!exists) {
			throw new IllegalStateException("Personalized Message" + personalizedMessageId + " does not exist");
		}
		personalizedMessageRepository.deleteById(personalizedMessageId);
		}
	

}
