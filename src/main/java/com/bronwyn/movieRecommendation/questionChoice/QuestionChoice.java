package com.bronwyn.movieRecommendation.questionChoice;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bronwyn.movieRecommendation.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "question_choice")
public class QuestionChoice {

	@Id
	@SequenceGenerator(name = "question_choice_sequence", sequenceName = "question_choice_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_choice_sequence")
	protected long id;
	String choicePrompt;
	
	@Enumerated(EnumType.STRING)
	protected ChoiceValue choiceValue;
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName = "id")
	protected Question question; 
	 

	public QuestionChoice(String choicePrompt, ChoiceValue choiceValue) {
		this.choicePrompt = choicePrompt;
		this.choiceValue = choiceValue;
	}
	
	public QuestionChoice(String choicePrompt, Question question) {
	        this.choicePrompt = choicePrompt;
	        this.question = question;
	    }
	 
	    public QuestionChoice(String choicePrompt) {
	        this.choicePrompt = choicePrompt;
	    }

	public QuestionChoice() {
	}
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getChoicePrompt() {
		return choicePrompt;
	}

	public void setChoicePrompt(String choicePrompt) {
		this.choicePrompt = choicePrompt;
	}
	
	public ChoiceValue getChoiceValue() {
		return choiceValue;
	}

	public void setChoiceValue(ChoiceValue choiceValue) {
		this.choiceValue = choiceValue;
	}

}
