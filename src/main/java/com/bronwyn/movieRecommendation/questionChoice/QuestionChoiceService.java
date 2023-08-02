package com.bronwyn.movieRecommendation.questionChoice;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bronwyn.movieRecommendation.question.Question;
@Service
public class QuestionChoiceService {
	
	

private final QuestionChoiceRepository questionChoiceRepository;
	
	
	@Autowired
	public QuestionChoiceService(QuestionChoiceRepository questionChoiceRepository) {
		this.questionChoiceRepository = questionChoiceRepository;
	}

	public void addNewQuestionChoice(QuestionChoice questionChoice) {
	    Question question = questionChoice.getQuestion();
	    if (question != null) {
	        questionChoice.setQuestion(question);
	    }
	    questionChoiceRepository.save(questionChoice);
	}
	

	public Optional<QuestionChoice> findQuestionChoiceByID(long questionChoiceID) {
	    return questionChoiceRepository.findById(questionChoiceID);
	}

	public void deleteQuestionChoice(Long questionChoiceId) {
		boolean exists = questionChoiceRepository.existsById(questionChoiceId);
		if(!exists) {
			throw new IllegalStateException("Question with Id " + questionChoiceId + " does not exist");
		}
		questionChoiceRepository.deleteById(questionChoiceId);
		}
	
	@Transactional
	public void updateQuestionChoice(Long questionId, String choicePrompt, ChoiceValue choiceValue) {
		QuestionChoice questionChoice = questionChoiceRepository.findById(questionId)
				.orElseThrow(() -> new IllegalStateException("Question with Id " + questionId + " does not exist"));			
		if(choicePrompt != null && choicePrompt.length() > 0 && !Objects.equals(questionChoice.getChoicePrompt(), choicePrompt)) {
			questionChoice.setChoicePrompt(choicePrompt);;
		}
		
		if(choiceValue != null && !Objects.equals(questionChoice.getValue(), choiceValue)) {
			questionChoice.setValue(choiceValue);;
		
		}
	}

	
	
}

