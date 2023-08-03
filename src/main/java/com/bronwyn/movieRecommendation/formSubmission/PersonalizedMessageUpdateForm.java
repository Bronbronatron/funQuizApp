package com.bronwyn.movieRecommendation.formSubmission;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.bronwyn.movieRecommendation.personalizedMessage.AnswerChoice;

public class PersonalizedMessageUpdateForm {

	public PersonalizedMessageUpdateForm(String message, AnswerChoice answerChoice) {
		this.message = message;
		this.answerChoice = answerChoice;
	}

	protected String message;

	@Enumerated(EnumType.STRING)
	protected AnswerChoice answerChoice;

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
	
	 @Override
	    public String toString() {
	        return "PersonalizedMessageUpdateForm{" +
	                "message='" + message + '\'' +
	                ", answerChoice=" + answerChoice +
	                '}';
	    }

}
