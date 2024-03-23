package com.bronwyn.movieRecommendation.formSubmission;

import java.util.ArrayList;
import java.util.List;

import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.question.Question;


public class QuizUpdateForm {
	protected long id;
	protected String quizTitle;
	protected List<QuestionUpdateForm> quizQuestion = new ArrayList<QuestionUpdateForm>();
	protected List<PersonalizedMessageUpdateForm> personalizedMessage = new ArrayList<PersonalizedMessageUpdateForm>();

	
	public QuizUpdateForm(Long id, String quizTitle, List<QuestionUpdateForm> quizQuestion,
			List<PersonalizedMessageUpdateForm> personalizedMessage) {
		super();
		this.quizTitle = quizTitle;
		this.quizQuestion = quizQuestion;
		this.personalizedMessage = personalizedMessage;
		this.id = id;
	}


	public QuizUpdateForm() {
	
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getQuizTitle() {
		return quizTitle;
	}


	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}


	public List<QuestionUpdateForm> getQuizQuestion() {
		return quizQuestion;
	}


	public void setQuizQuestion(List<QuestionUpdateForm> quizQuestion) {
		this.quizQuestion = quizQuestion;
	}


	public List<PersonalizedMessageUpdateForm> getPersonalizedMessage() {
		return personalizedMessage;
	}


	public void setPersonalizedMessage(List<PersonalizedMessageUpdateForm> personalizedMessage) {
		this.personalizedMessage = personalizedMessage;
	}
	
}

