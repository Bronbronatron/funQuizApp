package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Question {
	
	@Id
	@SequenceGenerator(name = "question_sequence", sequenceName = "question_sequence", allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
	protected long id;
	protected String prompt;
	protected String topic;
	protected LocalDateTime createdAt; 
	@ElementCollection
    private List<String> choices;
    private String selectedChoice;
	


	public Question() {
	}

	public Question(String prompt) {
		this.prompt = prompt;
	}

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

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	public String getSelectedChoice() {
		return selectedChoice;
	}

	public void setSelectedChoice(String selectedChoice) {
		this.selectedChoice = selectedChoice;
	}
	

}
