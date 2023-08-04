package com.bronwyn.movieRecommendation.personalizedMessage;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "personalized_message")
public class PersonalizedMessage {


	@Id
    @SequenceGenerator(name = "answer_choice_sequence", sequenceName = "answer_choice_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_choice_sequence")
	protected Long id;
	
	protected String message;
	
	@Enumerated(EnumType.STRING)
	protected AnswerChoice answerChoice;

	
	public PersonalizedMessage(String message, AnswerChoice answerChoice) {
		this.message = message;
		this.answerChoice = answerChoice;
	}

	public PersonalizedMessage() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AnswerChoice getAnswerChoice() {
		return answerChoice;
	}

	public void setAnswerChoice(AnswerChoice answerChoice) {
		this.answerChoice = answerChoice;
	}
	
	
	
}
