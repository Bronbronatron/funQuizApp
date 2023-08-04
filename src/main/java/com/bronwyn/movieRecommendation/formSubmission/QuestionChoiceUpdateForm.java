package com.bronwyn.movieRecommendation.formSubmission;

import com.bronwyn.movieRecommendation.personalizedMessage.AnswerChoice;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;

public class QuestionChoiceUpdateForm {

	public QuestionChoiceUpdateForm() {

	}


	public QuestionChoiceUpdateForm(String choicePrompt, AnswerChoice answerChoice, ChoiceValue choiceValue) {
		super();
		this.choicePrompt = choicePrompt;
		this.answerChoice = answerChoice;
		this.choiceValue = choiceValue;
	}

	private String choicePrompt;
	private AnswerChoice answerChoice;
	protected ChoiceValue choiceValue;
	
	 public QuestionChoiceUpdateForm(String choicePrompt, AnswerChoice answerChoice) {
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


	   @Override
	    public String toString() {
	        return "QuestionChoiceUpdateForm{" +
	                "choicePrompt='" + choicePrompt + '\'' +
	                ", answerChoice=" + answerChoice +
	                '}';
	    }

	public ChoiceValue getChoiceValue() {
		return choiceValue;
	}

	public void setChoiceValue(ChoiceValue choiceValue) {
		this.choiceValue = choiceValue;
	}
	}
	

