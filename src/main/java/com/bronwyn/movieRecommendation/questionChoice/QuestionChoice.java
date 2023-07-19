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

@Entity
@Table(name = "question_choice")
public class QuestionChoice {
	
	@Id
	@SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
	protected long id;
	String ChoicePrompt;
	
	@Enumerated(EnumType.STRING)
	ChoiceValue value;
	
	 
	public QuestionChoice(String choicePrompt, ChoiceValue value) {
		ChoicePrompt = choicePrompt;
		this.value = value;
	}

	public QuestionChoice() {
	}

	public String getChoicePrompt() {
		return ChoicePrompt;
	}

	public void setChoicePrompt(String choicePrompt) {
		ChoicePrompt = choicePrompt;
	}

	public ChoiceValue getValue() {
		return value;
	}

	public void setValue(ChoiceValue value) {
		this.value = value;
	}

}
