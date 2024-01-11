package com.bronwyn.movieRecommendation.formSubmission;

import java.util.List;

public class QuestionUpdateForm {


	public QuestionUpdateForm() {
	
	}

	
	private String prompt;
	private List<QuestionChoiceUpdateForm> questionChoiceUpdateForm;

	
    public QuestionUpdateForm(List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
		
		this.questionChoiceUpdateForm = questionChoiceUpdateForm;
	}



	public QuestionUpdateForm(String prompt, List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
        this.prompt = prompt;
        this.questionChoiceUpdateForm = questionChoiceUpdateForm;
    }


	
	@Override
	public String toString() {
		return "QuestionUpdateForm{" + "prompt='" + prompt + '\'' + '\'' + ", questionChoices="
				+ questionChoiceUpdateForm + '}';

	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}


	public List<QuestionChoiceUpdateForm> getQuestionChoiceUpdateForm() {
		return questionChoiceUpdateForm;
	}

	public void setQuestionChoiceUpdateForm(List<QuestionChoiceUpdateForm> questionChoiceUpdateForm) {
		this.questionChoiceUpdateForm = questionChoiceUpdateForm;
	}
}