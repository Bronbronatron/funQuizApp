package com.bronwyn.movieRecommendation.questionChoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, Long> {

}
