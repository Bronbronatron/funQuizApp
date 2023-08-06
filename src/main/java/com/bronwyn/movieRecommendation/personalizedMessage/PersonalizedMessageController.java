package com.bronwyn.movieRecommendation.personalizedMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bronwyn.movieRecommendation.formSubmission.PersonalizedMessageUpdateForm;

@RestController
@RequestMapping(path = "api/v1/message")
public class PersonalizedMessageController {

	public PersonalizedMessageController(PersonalizedMessageService personalizedMessageService) {
		this.personalizedMessageService = personalizedMessageService;
	}

	@Autowired
	private final PersonalizedMessageService personalizedMessageService;

	@PostMapping("{quizId}")
	public void registerNewPersonalizedMessage(@PathVariable Long quizId, @RequestBody PersonalizedMessage personalizedMessage) {
		personalizedMessageService.addNewPersonalizedMessage(quizId, personalizedMessage);
	}

	@DeleteMapping(path = "{personalizedMessageId}")
	public void deletePersonalizedMessage(@PathVariable("personalizedMessageId") Long personalizedMessageId) {
		personalizedMessageService.deletePersonalizedMessage(personalizedMessageId);

	}

	@PutMapping(path = "{personalizedMessageId}")
	public void updatePersonalizedMessage(@PathVariable Long personalizedMessageId,
			@RequestBody PersonalizedMessageUpdateForm personalizedMessageUpdateForm) {
		personalizedMessageService.updatePersonalizedMessageUsingForm(personalizedMessageId,
				personalizedMessageUpdateForm);
	}

	@GetMapping
	public List<PersonalizedMessage> getAllPersonalizedMessage() {
		return personalizedMessageService.getAllPersonalizedMessage();
	}

}
