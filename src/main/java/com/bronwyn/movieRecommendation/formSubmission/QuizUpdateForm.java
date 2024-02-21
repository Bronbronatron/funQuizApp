package com.bronwyn.movieRecommendation.formSubmission;

import java.util.ArrayList;
import java.util.List;

import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.question.Question;


public class QuizUpdateForm {
	protected String quizTitle;
	protected List<Question> quizQuestion = new ArrayList<Question>();
	protected List<PersonalizedMessage> personalizedMessage = new ArrayList<PersonalizedMessage>();

	
	public QuizUpdateForm(String quizTitle, List<Question> quizQuestion,
			List<PersonalizedMessage> personalizedMessage) {
		super();
		this.quizTitle = quizTitle;
		this.quizQuestion = quizQuestion;
		this.personalizedMessage = personalizedMessage;
	}


	public QuizUpdateForm() {
	
	}


	public String getQuizTitle() {
		return quizTitle;
	}


	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}


	public List<Question> getQuizQuestion() {
		return quizQuestion;
	}


	public void setQuizQuestion(List<Question> quizQuestion) {
		this.quizQuestion = quizQuestion;
	}


	public List<PersonalizedMessage> getPersonalizedMessage() {
		return personalizedMessage;
	}


	public void setPersonalizedMessage(List<PersonalizedMessage> personalizedMessage) {
		this.personalizedMessage = personalizedMessage;
	}

	
	
	
}

