package com.bronwyn.movieRecommendation.question;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
	


}
