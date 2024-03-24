package com.bronwyn.movieRecommendation.formSubmission;

import java.util.List;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.bronwyn.movieRecommendation.quiz.Quiz;

public class QuestionUpdateForm {


	public QuestionUpdateForm() {
	
	}

	public QuestionUpdateForm(long id, String prompt, List<QuestionChoiceUpdateForm> questionChoice, Quiz quiz) {
		super();
		this.id = id;
		this.prompt = prompt;
		this.questionChoice = questionChoice;
		this.quiz = quiz;
	}

	protected long id;
	private String prompt;
	private List<QuestionChoiceUpdateForm> questionChoice;
	
	
	protected Quiz quiz;

	
    public List<QuestionChoiceUpdateForm> getQuestionChoice() {
		return questionChoice;
	}



	public void setQuestionChoice(List<QuestionChoiceUpdateForm> questionChoice) {
		
		this.questionChoice = questionChoice;
	}



	public Quiz getQuiz() {
		return quiz;
	}



	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}



	public QuestionUpdateForm(List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
		this.questionChoice = questionChoiceUpdateForm;
	}



	public QuestionUpdateForm(String prompt, List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
        this.prompt = prompt;
        this.questionChoice = questionChoiceUpdateForm;
    }


	
	@Override
	public String toString() {
		return "QuestionUpdateForm{" + "prompt='" + prompt + '\'' + '\'' + ", questionChoices="
				+ questionChoice + '}';

	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}


}