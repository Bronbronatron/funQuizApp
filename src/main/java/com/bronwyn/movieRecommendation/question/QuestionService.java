package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoiceRepository;

@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	private final QuestionChoiceRepository questionChoiceRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository, QuestionChoiceRepository questionChoiceRepository) {
		this.questionRepository = questionRepository;
		this.questionChoiceRepository = questionChoiceRepository;
	}

	@Transactional
	public void addNewQuestionWithChoice(Question question) {
		Optional<Question> questionByPrompt = questionRepository.findQuestionByPrompt(question.getPrompt());
		if (questionByPrompt.isPresent()) {
			throw new IllegalStateException("Question already exists");
		}
		question.setCreatedAt(LocalDateTime.now());
		List<QuestionChoice> questionChoices = question.getQuestionChoice();
		if (questionChoices != null) {

			for (QuestionChoice choice : questionChoices) {
				System.out.println("Setting choices.." + choice);
				choice.setQuestion(question);
			}
		}

		questionRepository.save(question);
	}

	

	
	@Transactional
	public List<Question> getQuestion() {
		return questionRepository.findAll();

	}

	@Transactional
	public Optional<Question> findQuestionByID(long questionID) {
		return questionRepository.findById(questionID);
	}

	@Transactional
	public void deleteQuestion(Long questionId) {
		boolean exists = questionRepository.existsById(questionId);
		if (!exists) {
			throw new IllegalStateException("Question with Id " + questionId + " does not exist");
		}
		questionRepository.deleteById(questionId);
	}

	@Transactional
	public void updateQuestion(Question updatedQuestion, Question existingQuestion) {
		if (updatedQuestion.getPrompt() != null && !updatedQuestion.getPrompt().isEmpty()
				&& !Objects.equals(existingQuestion.getPrompt(), updatedQuestion.getPrompt())) {
			existingQuestion.setPrompt(updatedQuestion.getPrompt());
		}

		if (updatedQuestion.getTopic() != null && !updatedQuestion.getTopic().isEmpty()
				&& !Objects.equals(existingQuestion.getTopic(), updatedQuestion.getTopic())) {
			existingQuestion.setTopic(updatedQuestion.getTopic());
		}

		List<QuestionChoice> existingChoices = existingQuestion.getQuestionChoice();
		List<QuestionChoice> updatedChoices = updatedQuestion.getQuestionChoice();
		for (int i = 0; i < existingChoices.size(); i++) {
			QuestionChoice existingChoice = existingChoices.get(i);
			QuestionChoice updatedChoice = updatedChoices.get(i);

			existingChoice.setChoicePrompt(updatedChoice.getChoicePrompt());
			existingChoice.setChoiceValue(updatedChoice.getChoiceValue());
			
		}

		questionRepository.save(existingQuestion);
	}

}
