package com.bronwyn.movieRecommendation.personalizedMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/message")
public class PersonalizedMessageController {
	
	
	public PersonalizedMessageController(PersonalizedMessageService personalizedMessageService) {
				this.personalizedMessageService = personalizedMessageService;
	}
	
	@Autowired
	private final PersonalizedMessageService personalizedMessageService;
	
	@PostMapping
	public void registerNewPersonalizedMessage(@RequestBody PersonalizedMessage personalizedMessage) {
		personalizedMessageService.addNewPersonalizedMessage(personalizedMessage);
	}
		
	@DeleteMapping(path = "{personalizedMessageId}")
	public void deletePersonalizedMessage(@PathVariable("personalizedMessageId") Long personalizedMessageId) {
		personalizedMessageService.deletePersonalizedMessage(personalizedMessageId);
		
	}
		
	}




