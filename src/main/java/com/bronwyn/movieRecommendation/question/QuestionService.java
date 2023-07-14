package com.bronwyn.movieRecommendation.question;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class QuestionService {
	
	
	private final QuestionRepository questionRepository;
	
	
	@Autowired
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	public List<Question> getQuestion() {
		    return questionRepository.findAll() ;

	}

	public void addNewQuestion(Question question) {
		Optional<Question> questionByPrompt = questionRepository.findQuestionByPrompt(question.getPrompt());
		if(questionByPrompt.isPresent()) {
			throw new IllegalStateException("Question already exists");
		}
		question.setCreatedAt(LocalDateTime.now());
		questionRepository.save(question);
	}

	public void deleteQuestion(Long questionId) {
		boolean exists = questionRepository.existsById(questionId);
		if(!exists) {
			throw new IllegalStateException("Question with Id " + questionId + " does not exist");
		}
		questionRepository.deleteById(questionId);
		}
	
	@Transactional
	public void updateQuestion(Long questionId, String prompt, String topic) {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new IllegalStateException("Question with Id " + questionId + " does not exist"));			
		if(prompt != null && prompt.length() > 0 && !Objects.equals(question.getPrompt(), prompt)) {
			question.setPrompt(prompt);;
		}
		
		if(topic != null && topic.length() > 0 && !Objects.equals(question.getTopic(), topic)) {
			question.setTopic(topic);;
		
		}
	}
	
}

