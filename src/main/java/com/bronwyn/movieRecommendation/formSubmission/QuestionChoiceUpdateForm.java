package com.bronwyn.movieRecommendation.formSubmission;

import com.bronwyn.movieRecommendation.personalizedMessage.AnswerChoice;

public class QuestionChoiceUpdateForm {
	
	 public QuestionChoiceUpdateForm(String choicePrompt, AnswerChoice answerChoice) {
		super();
		this.choicePrompt = choicePrompt;
		this.answerChoice = answerChoice;
	}

	public String getChoicePrompt() {
		return choicePrompt;
	}

	public void setChoicePrompt(String choicePrompt) {
		this.choicePrompt = choicePrompt;
	}

	public AnswerChoice getAnswerChoice() {
		return answerChoice;
	}

	public void setAnswerChoice(AnswerChoice answerChoice) {
		this.answerChoice = answerChoice;
	}

	private String choicePrompt;
	 private AnswerChoice answerChoice;

	   @Override
	    public String toString() {
	        return "QuestionChoiceUpdateForm{" +
	                "choicePrompt='" + choicePrompt + '\'' +
	                ", answerChoice=" + answerChoice +
	                '}';
	    }
	}
	

