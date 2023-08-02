package com.bronwyn.movieRecommendation.formSubmission;

import java.util.List;

public class QuestionUpdateForm {

	private String prompt;
	private String topic;
	private List<QuestionChoiceUpdateForm> questionChoices;

	@Override
	public String toString() {
		return "QuestionUpdateForm{" + "prompt='" + prompt + '\'' + ", topic='" + topic + '\'' + ", questionChoices="
				+ questionChoices + '}';

	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<QuestionChoiceUpdateForm> getQuestionChoices() {
		return questionChoices;
	}

	public void setQuestionChoices(List<QuestionChoiceUpdateForm> questionChoices) {
		this.questionChoices = questionChoices;
	}
}