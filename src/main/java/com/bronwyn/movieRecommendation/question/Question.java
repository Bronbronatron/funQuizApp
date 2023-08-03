package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Entity
public class Question {
	
	public Question(String prompt) {
		this.prompt = prompt;
	}

	public Question() {
	}

	public Question(String prompt, String topic, List<QuestionChoice> questionChoice) {
		this.prompt = prompt;
		this.topic = topic;
		this.questionChoice = questionChoice;
	}

	@Id
	@SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
	protected long id;
	protected String prompt;
	protected String topic;
	protected LocalDateTime createdAt; 
	
	
	@OneToMany(mappedBy = "question", cascade=CascadeType.ALL)
    protected List<QuestionChoice> questionChoice = new ArrayList<QuestionChoice>();

	public Question(String prompt, String topic) {
		this.prompt = prompt;
		this.topic = topic;
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

	public long getId() {
		return id;
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

	public List<QuestionChoice> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(List<QuestionChoice> questionChoice) {
		this.questionChoice = questionChoice;
	}
	
	
}
