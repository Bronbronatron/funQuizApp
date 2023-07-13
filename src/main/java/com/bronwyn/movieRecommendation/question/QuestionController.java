package com.bronwyn.movieRecommendation.question;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping	(path = "api/v1/question")
public class QuestionController {
	
	@Autowired
	private final QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

@GetMapping
public List<Question> getQuestion() {
	return questionService.getQuestion();
}
@PostMapping
public void registerNewQuestion(@RequestBody Question question) {
	questionService.addNewQuestion(question);
}

}
