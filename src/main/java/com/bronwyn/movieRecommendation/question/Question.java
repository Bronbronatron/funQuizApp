package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
	protected long id;
	protected String prompt;
	protected String topic;
	@ElementCollection
    private List<QuestionChoice> choices;
	protected LocalDateTime createdAt; 
	
	
    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade=CascadeType.ALL)
    protected List<QuestionChoice> questionChoice = new ArrayList<QuestionChoice>();

	public Question() {
	}

	public Question(String prompt) {
		this.prompt = prompt;
	}

	public Question(String prompt, String topic) {
		this.prompt = prompt;
		this.topic = topic;
	}


	public Question(String prompt, String topic, List<QuestionChoice> choices) {
		this.prompt = prompt;
		this.topic = topic;
		this.choices = choices;
	}

	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String toString() {
		return "Question [prompt=" + prompt + "]";
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<QuestionChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<QuestionChoice> choices) {
		this.choices = choices;
	}

	public List<QuestionChoice> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(List<QuestionChoice> questionChoice) {
		this.questionChoice = questionChoice;
	}
	
	
/*
	public QuestionChoice getSelectedChoice() {
		return selectedChoice;
	}

	public void setSelectedChoice(QuestionChoice selectedChoice) {
		this.selectedChoice = selectedChoice;
	}
	
*/
}
