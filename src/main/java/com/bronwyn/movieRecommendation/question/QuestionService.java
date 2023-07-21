package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoiceRepository;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	private final QuestionChoiceRepository questionChoiceRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository, QuestionChoiceRepository questionChoiceRepository) {
		this.questionChoiceRepository = questionChoiceRepository;
		this.questionRepository = questionRepository;
	}

	public List<Question> getQuestion() {
		return questionRepository.findAll();

	}

	@Transactional
	public void addNewQuestionWithChoice(Question question) {
		Optional<Question> questionByPrompt = questionRepository.findQuestionByPrompt(question.getPrompt());
		if (questionByPrompt.isPresent()) {
			throw new IllegalStateException("Question already exists");
		}
		question.setCreatedAt(LocalDateTime.now());
		questionRepository.save(question);
	}

	
	
	public Optional<Question> findQuestionByID(long questionID) {
	    return questionRepository.findById(questionID);
	}

	
	public void deleteQuestion(Long questionId) {
		boolean exists = questionRepository.existsById(questionId);
		if (!exists) {
			throw new IllegalStateException("Question with Id " + questionId + " does not exist");
		}
		questionRepository.deleteById(questionId);
	}

	@Transactional
	public void updateQuestion(Long questionId, String prompt, String topic) {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new IllegalStateException("Question with Id " + questionId + " does not exist"));
		if (prompt != null && prompt.length() > 0 && !Objects.equals(question.getPrompt(), prompt)) {
			question.setPrompt(prompt);
			;
		}

		if (topic != null && topic.length() > 0 && !Objects.equals(question.getTopic(), topic)) {
			question.setTopic(topic);
			;

		}
}
	@Transactional
    public void saveQuestionWithChoices(Question question, List<QuestionChoice> choices) {
        // Save the question first (assuming you have a repository for Question)
        Question savedQuestion = questionRepository.save(question);

        // Associate the choices with the saved question
        for (QuestionChoice choice : choices) {
            choice.setQuestion(savedQuestion);
        }

        // Save the choices (assuming you have a repository for Choice)
        questionChoiceRepository.saveAll(choices);
    }
	
}	
	


