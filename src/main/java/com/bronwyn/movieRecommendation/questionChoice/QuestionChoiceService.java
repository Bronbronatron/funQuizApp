package com.bronwyn.movieRecommendation.questionChoice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bronwyn.movieRecommendation.formSubmission.QuestionChoiceUpdateForm;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.question.QuestionRepository;

@Service
public class QuestionChoiceService {

	private final QuestionChoiceRepository questionChoiceRepository;
	private final QuestionRepository questionRepository;

	@Autowired
	public QuestionChoiceService(QuestionChoiceRepository questionChoiceRepository,
			QuestionRepository questionRepository) {
		this.questionChoiceRepository = questionChoiceRepository;
		this.questionRepository = questionRepository;
	}

	@Transactional
	public void addNewQuestionChoice(Long questionId, QuestionChoice questionChoice) {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new IllegalStateException("Question with Id " + questionId + " does not exist"));
		questionChoice.setQuestion(question);
		questionChoice.setChoiceValue(questionChoice.getChoiceValue());
		questionChoiceRepository.save(questionChoice);
	}

	@Transactional
	public Optional<QuestionChoice> findQuestionChoiceByID(long questionChoiceID) {
		return questionChoiceRepository.findById(questionChoiceID);
	}
	
	@Transactional
	public List<QuestionChoice> getAllQuestionChoices() {
		return questionChoiceRepository.findAll();
	}

	@Transactional
	public void deleteQuestionChoice(Long questionChoiceId) {
		boolean exists = questionChoiceRepository.existsById(questionChoiceId);
		if (!exists) {
			throw new IllegalStateException("Question with Id " + questionChoiceId + " does not exist");
		}
		questionChoiceRepository.deleteById(questionChoiceId);
	}

	@Transactional
	public void updateQuestionChoiceUsingForm(Long questionChoiceId,
			QuestionChoiceUpdateForm questionChoiceUpdateForm) {
		QuestionChoice questionChoice = questionChoiceRepository.findById(questionChoiceId).orElseThrow(
				() -> new IllegalStateException("Question with Id " + questionChoiceId + " does not exist"));

		String updatedChoicePrompt = questionChoiceUpdateForm.getChoicePrompt();
		if (updatedChoicePrompt != null && !updatedChoicePrompt.isEmpty()) {
			questionChoice.setChoicePrompt(updatedChoicePrompt);
		}

		ChoiceValue updatedChoiceValue = questionChoiceUpdateForm.getChoiceValue();
		if (updatedChoicePrompt != null) {
			questionChoice.setChoiceValue(updatedChoiceValue);
		}
		questionChoiceRepository.save(questionChoice);

	}

}
