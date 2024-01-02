package com.bronwyn.movieRecommendation.quiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.question.Question;

@Entity
@Table(name = "quiz")
public class Quiz {

	public Quiz(String quizTitle, List<Question> quizQuestion, List<PersonalizedMessage> personalizedMessage) {
		super();
		this.quizTitle = quizTitle;
		this.quizQuestion = quizQuestion;
		this.personalizedMessage = personalizedMessage;
	}

	public Quiz(String quizTitle) {
		super();
		this.quizTitle = quizTitle;
	}

	public Quiz() {
	}

	@Id
	@SequenceGenerator(name = "quiz_sequence", sequenceName = "quiz_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_sequence")
	protected long id;
	protected String quizTitle;
	protected LocalDateTime createdAt;

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	protected List<Question> quizQuestion = new ArrayList<Question>();

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	protected List<PersonalizedMessage> personalizedMessage = new ArrayList<PersonalizedMessage>();

	public Quiz(long id, String quizTitle, LocalDateTime createdAt, List<Question> quizQuestion) {
		super();
		this.id = id;
		this.quizTitle = quizTitle;
		this.createdAt = createdAt;
		this.quizQuestion = quizQuestion;
	}

	public Quiz(String quizTitle, List<Question> quizQuestion) {
		this.quizTitle = quizTitle;
		this.quizQuestion = quizQuestion;
	}
	
	
	public Long getId() {
	    return id;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Question> getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(List<Question> quizQuestion) {
		this.quizQuestion = quizQuestion;
	}

	@Override
	public String toString() {
		return "Quiz{" + "id=" + id + ", quizTitle='" + quizTitle + '\'' + ", createdAt=" + createdAt
				+ ", quizQuestion=" + quizQuestion + '}';
	}

	public List<PersonalizedMessage> getPersonalizedMessage() {
		return personalizedMessage;
	}

	public void setPersonalizedMessage(List<PersonalizedMessage> personalizedMessage) {
		this.personalizedMessage = personalizedMessage;
	}

}
