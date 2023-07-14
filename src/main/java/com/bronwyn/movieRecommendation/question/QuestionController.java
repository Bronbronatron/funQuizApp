package com.bronwyn.movieRecommendation.question;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@DeleteMapping(path = "{questionId}" )
public void deleteQuestion(@PathVariable("questionId") Long questionId) {
	questionService.deleteQuestion(questionId);
}

@PutMapping(path = "{questionId}" )
public void updateQuestion(@PathVariable("questionId") Long questionId,
	@RequestParam(required = false) String prompt,
	@RequestParam(required = false) String topic) {
	questionService.updateQuestion(questionId, prompt, topic);
}


}
