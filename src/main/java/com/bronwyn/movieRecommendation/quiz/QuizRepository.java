package com.bronwyn.movieRecommendation.quiz;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	
	@Query("SELECT q FROM Quiz q WHERE q.quizTitle =?1")
	Optional<Quiz> findQuizByQuizTitle(String quizTitle);
	

}
