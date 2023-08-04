package com.bronwyn.movieRecommendation.formSubmission;

import java.util.List;

public class QuestionUpdateForm {


	public QuestionUpdateForm() {
	
	}

	
	private String prompt;
	private String topic;
	private List<QuestionChoiceUpdateForm> questionChoiceUpdateForm;

	
    public QuestionUpdateForm(List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
		
		this.questionChoiceUpdateForm = questionChoiceUpdateForm;
	}



	public QuestionUpdateForm(String prompt, String topic, List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
        this.prompt = prompt;
        this.topic = topic;
        this.questionChoiceUpdateForm = questionChoiceUpdateForm;
    }


	
	@Override
	public String toString() {
		return "QuestionUpdateForm{" + "prompt='" + prompt + '\'' + ", topic='" + topic + '\'' + ", questionChoices="
				+ questionChoiceUpdateForm + '}';

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

	public List<QuestionChoiceUpdateForm> getQuestionChoiceUpdateForm() {
		return questionChoiceUpdateForm;
	}

	public void setQuestionChoiceUpdateForm(List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
		this.questionChoiceUpdateForm = questionChoiceUpdateForm;
	}
}