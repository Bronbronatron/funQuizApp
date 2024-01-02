package com.bronwyn.movieRecommendation.quiz;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

@Service
public class QuizService {

	private final QuizRepository quizRepository;

	@Autowired
	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;

	}

	@Transactional
	public void addNewQuizWithQuestion(Quiz quiz) {
	    Optional<Quiz> quizByQuizTitle = quizRepository.findQuizByQuizTitle(quiz.getQuizTitle());
	    if (quizByQuizTitle.isPresent()) {
	        throw new IllegalStateException("Quiz already exists");
	    }

	    LocalDateTime currentTimestamp = LocalDateTime.now();
	    quiz.setCreatedAt(currentTimestamp);

	    List<PersonalizedMessage> personalizedMessages = quiz.getPersonalizedMessage();
	    if (personalizedMessages != null) {
	        for (PersonalizedMessage personalizedMessage : personalizedMessages) {
	            personalizedMessage.setQuiz(quiz);
	        }
	    }

	    List<Question> questions = quiz.getQuizQuestion();
	    if (questions != null) {
	        for (Question question : questions) {
	            question.setQuiz(quiz);
	            question.setCreatedAt(currentTimestamp);

	            List<QuestionChoice> choices = question.getQuestionChoice();
	            if (choices != null) {
	                for (QuestionChoice choice : choices) {
	                    choice.setQuestion(question);
	                }
	            }
	        }
	    }

	    quizRepository.save(quiz);
	}
	
	@Transactional(readOnly = true)
	public List<Quiz> getAllQuizzes() {
		return quizRepository.findAll();
	}



	@Transactional
	public void deleteQuiz(Long quizId) {
		boolean exists = quizRepository.existsById(quizId);
		if (!exists) {
			throw new IllegalStateException("Quiz with Id " + quizId + " does not exist");
		}
		quizRepository.deleteById(quizId);
	}

	@Transactional(readOnly = true)
	public Optional<Quiz> findQuizByID(Long quizId) {
		return quizRepository.findById(quizId);
	}

}