package com.bronwyn.movieRecommendation.quiz;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bronwyn.movieRecommendation.formSubmission.QuestionChoiceUpdateForm;
import com.bronwyn.movieRecommendation.formSubmission.QuestionUpdateForm;
import com.bronwyn.movieRecommendation.formSubmission.QuizUpdateForm;
import com.bronwyn.movieRecommendation.personalizedMessage.AnswerChoice;
import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessage;
import com.bronwyn.movieRecommendation.personalizedMessage.PersonalizedMessageService;
import com.bronwyn.movieRecommendation.question.Question;
import com.bronwyn.movieRecommendation.question.QuestionService;
import com.bronwyn.movieRecommendation.questionChoice.ChoiceValue;
import com.bronwyn.movieRecommendation.questionChoice.QuestionChoice;

//Use @Controller for traditional web applications, that render html webpages
@Controller
@RequestMapping(path = "api/v1/quiz")
public class QuizController {

	@Autowired
	private final QuizRepository quizRepository;
	private final QuizService quizService;
	private final QuestionService questionService;
	private final PersonalizedMessageService personalizedMessageService;

	public QuizController(QuizService quizService, QuestionService questionService, QuizRepository quizRepository,
			PersonalizedMessageService personalizedMessageService) {
		this.quizService = quizService;
		this.questionService = questionService;
		this.personalizedMessageService = personalizedMessageService;
		this.quizRepository = quizRepository;
	}

	@GetMapping("/{quizId}")
	public Optional<Quiz> findQuestionByID(@PathVariable Long quizId) {
		return quizService.findQuizByID(quizId);
	}

	@GetMapping(path = "/createQuiz")
	// The Model object is provided by Spring and is used to pass data to the view.
	public String showQuizFrom(Model model) {
		Quiz quiz = new Quiz();
		model.addAttribute("quiz", quiz);
		model.addAttribute("choiceValues", ChoiceValue.values());
		model.addAttribute("answerChoice", AnswerChoice.values());
		return "quizForm";
	}

	@PostMapping("/registerQuiz")
	public String registerNewQuiz(@ModelAttribute("quiz") Quiz quiz) {
		quizService.addNewQuizWithQuestion(quiz);
		return "homeScreen";
	}

	@DeleteMapping(path = "{quizId}")
	public ResponseEntity<Void> deleteQuiz(@PathVariable("quizId") Long quizId) {
		quizService.deleteQuiz(quizId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/edit/{quizId}")
	public String getEditQuiz(Model model, @PathVariable("quizId") Long quizId) {

		try {
			Quiz quiz = quizService.findQuizByID(quizId).get();
			model.addAttribute("quiz", quiz);
			model.addAttribute("choiceValues", ChoiceValue.values());
		}

		catch (Exception ex) {
			System.out.println("Quiz does not exist");
			return "quizList";
		}
		return "updateQuiz";
	}

	@PostMapping("/submitEdit")
	public String postEditQuiz(@ModelAttribute("updateForm") QuizUpdateForm updateForm, Model model) {

		Long quizId = updateForm.getId();
		Optional<Quiz> optionalQuiz = quizService.findQuizByID(quizId);

		if (optionalQuiz.isPresent()) {
			Quiz existingQuiz = optionalQuiz.get();
			existingQuiz.setQuizTitle(updateForm.getQuizTitle());

			List<Question> ExistingQuestions = existingQuiz.getQuizQuestion();
			List<QuestionUpdateForm> quizQuestionList = updateForm.getQuizQuestion();

			for (int i = 0; i < ExistingQuestions.size(); i++) {
				Question question = ExistingQuestions.get(i);
				QuestionUpdateForm updatedQuestion = quizQuestionList.get(i);
				String updatedPrompt = updatedQuestion.getPrompt();
				question.setPrompt(updatedPrompt);

				List<QuestionChoice> existingChoicelist = question.getQuestionChoice();

				List<QuestionChoiceUpdateForm> questionChoicelist = updatedQuestion.getQuestionChoice();

				for (QuestionChoiceUpdateForm updatedQuestionChoice : questionChoicelist) {
					System.out.println("------------New Prompt-----------" + updatedQuestionChoice.getChoicePrompt());
					System.out.println("------------Choice Value-----------" + updatedQuestionChoice.getChoiceValue());

				}

				for (int j = 0; j < existingChoicelist.size(); j++) {
					QuestionChoice existingQuestionChoice = existingChoicelist.get(j);
					QuestionChoiceUpdateForm updatedQuestionChoice = questionChoicelist.get(j);
					existingQuestionChoice.setChoicePrompt(updatedQuestionChoice.getChoicePrompt());
					existingQuestionChoice.setChoiceValue(updatedQuestionChoice.getChoiceValue());

				}

			}
			quizRepository.save(existingQuiz);

			model.addAttribute("quizzes", quizService.getAllQuizzes());
			return "quizList";
		} else {
			System.out.println("Quiz not found");
			return "quizList";
		}
	}

	@GetMapping(path = "/selection")
	public String showQuizList(Model model) {
		// Retrieve the list of existing Quiz objects from the service or repository
		List<Quiz> quizzes = quizService.getAllQuizzes();
		// Add the list of quizzes to the model with the key "quizzes"
		model.addAttribute("quizzes", quizzes);
		// Return the name of the Thymeleaf template (quizList.html)
		return "quizList";

	}

	@GetMapping("/quiz/{quizId}")
	public String showQuizById(@PathVariable Long quizId, Model model) {
		// Logic to retrieve questions for the specified quizId
		List<Question> questions = quizService.getQuestionsForQuiz(quizId);
		// Retrieve the Quiz object
		Optional<Quiz> quiz = quizService.findQuizByID(quizId);

		// Check if the Quiz exists, then add it to the model
		quiz.ifPresent(q -> model.addAttribute("quiz", q));

		// Add the questions to the model
		// When you add an attribute to the model in your controller, you're saying, "In
		// my view, I want to access this data, and I'll refer to it using this key."
		model.addAttribute("questions", questions);

		// If questionChoice is not added to the model, it can still be displayed in the
		// Thymeleaf template, allowing users to make selections.
		// However, when form submitted, server won't automatically receive information
		// about the selected choices
		// unless you explicitly include them in the form data.

		// Loop through questions and add their choices to the model
		// if the first question has an ID of 1, the key will be "questionChoices_1", if
		// the second question has an ID of 2, the key will be "questionChoices_2 etc.
		for (Question question : questions) {
			model.addAttribute("questionChoices_" + question.getId(), question.getQuestionChoice());
		}

		// Return the name of the Thymeleaf template (showQuiz.html)
		return "showQuiz";
	}

	@PostMapping("/submitQuiz")
	public String submitQuiz(Model model, @RequestParam Map<String, String> formData) {
		// Extract answer choices from formData
		Map<String, String> answerChoices = formData.entrySet().stream()
				.filter(entry -> entry.getKey().startsWith("choice_")) // Assuming your answer choices start with
																		// "choice_"
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Extract quizId from formData
		Long quizId = Long.parseLong(formData.get("quizId"));

		String findMostCommonChoice = quizService.findMostCommonChoice(answerChoices);
		System.out.println("Answer Choices: " + answerChoices);
		System.out.println("Quiz ID: " + quizId);

		Optional<PersonalizedMessage> personalizedMessage = personalizedMessageService
				.getPersonalizedMessage(findMostCommonChoice, quizId);

		// Check if the personalizedMessage is present before adding it to the model
		if (personalizedMessage.isPresent()) {
			model.addAttribute("personalizedMessage", personalizedMessage.get());
		} else {
			// Handle the case where no personalized message is found for the
			// mostCommonChoice
			model.addAttribute("personalizedMessage", "Default Message or handle accordingly");
		}

		return "resultPage";
	}

}
