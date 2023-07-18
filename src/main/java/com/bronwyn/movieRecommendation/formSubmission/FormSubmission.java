package com.bronwyn.movieRecommendation.formSubmission;

import java.util.List;

import com.bronwyn.movieRecommendation.question.Question;

public class FormSubmission {
    public List<Question> questions;

	public FormSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormSubmission(List<Question> questions) {
		super();
		this.questions = questions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}




}
