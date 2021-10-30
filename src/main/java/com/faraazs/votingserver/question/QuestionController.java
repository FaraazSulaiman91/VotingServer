package com.faraazs.votingserver.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController
{
	private QuestionService questionService;

	QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@GetMapping("/questions")
	public List<Question> getQuestions(@RequestHeader long sessionCode)
	{
		return questionService.list(sessionCode);
	}

	@GetMapping("/questions/current")
	public Question getCurrentQuestion(@RequestHeader long sessionCode)
	{
		return questionService.getLatest(sessionCode);
	}

	@PostMapping("/questions")
	public Question createQuestion(@RequestHeader long sessionCode, @RequestBody Question question)
	{
		return questionService.create(sessionCode, question);
	}
}