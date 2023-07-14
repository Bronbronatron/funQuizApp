package com.bronwyn.movieRecommendation.question;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	
	@Query("SELECT q FROM Question q WHERE q.prompt =?1")
	Optional<Question> findQuestionByPrompt(String prompt);
	
	
	
}
