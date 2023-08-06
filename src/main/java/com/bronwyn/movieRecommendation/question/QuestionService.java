package com.bronwyn.movieRecommendation.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.formSubmission.QuestionChoiceUpdateForm;
import com.bronwyn.movieRecommendation.formSubmission.QuestionUpdateForm;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;
import com.bronwyn.movieRecommendation.quiz.Quiz;
import com.bronwyn.movieRecommendation.quiz.QuizRepository;

@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	private final QuizRepository quizRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
		this.questionRepository = questionRepository;
		this.quizRepository = quizRepository;
		
	}

	@Transactional
	public void addNewQuestionWithChoice(Long quizId, Question question) {
		
		Quiz quiz = quizRepository.findById(quizId)
				.orElseThrow(() -> new IllegalStateException("Quiz with Id " + quizId + " does not exist"));
	
		Optional<Question> questionByPrompt = questionRepository.findQuestionByPrompt(question.getPrompt());
		if (questionByPrompt.isPresent()) {
			throw new IllegalStateException("Question already exists");
		}
		question.setCreatedAt(LocalDateTime.now());
		question.setQuiz(quiz);
		List<QuestionChoice> questionChoices = question.getQuestionChoice();
		if (questionChoices != null) {

			for (QuestionChoice choice : questionChoices) {
				System.out.println("Setting choices.." + choice);
				choice.setQuestion(question);
			}
		}
		
		questionRepository.save(question);
	}

	
	@Transactional(readOnly = true)
	public List<Question> getQuestion() {
		return questionRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Question> findQuestionByID(long questionID) {
		return questionRepository.findById(questionID);
	}
	
	
    @Transactional(readOnly = true)
    public Optional<Question> findQuestionByTopic(String topic) {
        return questionRepository.findQuestionByTopic(topic);
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
	public void updateQuestionUsingForm(Long questionId, QuestionUpdateForm questionUpdateForm) {
	    Question existingQuestion = questionRepository.findById(questionId)
	            .orElseThrow(() -> new IllegalStateException("Question with Id " + questionId + " does not exist"));

	    String updatedPrompt = questionUpdateForm.getPrompt();
	    if (updatedPrompt != null && !updatedPrompt.isEmpty()) {
	        existingQuestion.setPrompt(updatedPrompt);
	    }

		// Update topic if provided in the form
		String updatedTopic = questionUpdateForm.getTopic();

		if (updatedTopic != null && !updatedTopic.isEmpty()) {
			existingQuestion.setTopic(updatedTopic);
		}

		List<QuestionChoice> existingChoices = existingQuestion.getQuestionChoice();
		List<QuestionChoiceUpdateForm> updatedChoiceForms = questionUpdateForm.getQuestionChoiceUpdateForm();

		for (int i = 0; i < existingChoices.size() && i < updatedChoiceForms.size(); i++) {

			QuestionChoice existingChoice = existingChoices.get(i);
			QuestionChoiceUpdateForm updatedChoiceForm = updatedChoiceForms.get(i);

			// Update choice prompt if provided in the form
	        String updatedChoicePrompt = updatedChoiceForm.getChoicePrompt();
	        if (updatedChoicePrompt != null && !updatedChoicePrompt.isEmpty()) {
	            existingChoice.setChoicePrompt(updatedChoicePrompt);
	        }
	        // Update choice value if provided in the form
	        ChoiceValue updatedChoiceValue = updatedChoiceForm.getChoiceValue();
	        if (updatedChoiceValue != null) {
	            existingChoice.setChoiceValue(updatedChoiceValue);
	        }
	    }

	    questionRepository.save(existingQuestion);
	    
	}


}
