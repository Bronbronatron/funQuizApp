package com.bronwyn.movieRecommendation.question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	//JPQL  perform database queries using entity objects and is designed to be similar to SQL, but it is used on objects rather than tables.
	@Query("SELECT q FROM Question q WHERE q.prompt =?1")
	Optional<Question> findQuestionByPrompt(String prompt);

	List<Question> findByQuizId(Long quizId);
	
	@Query("SELECT q FROM Question q WHERE q.topic =?1")
	Optional<Question> findQuestionByTopic(String topic);
}


