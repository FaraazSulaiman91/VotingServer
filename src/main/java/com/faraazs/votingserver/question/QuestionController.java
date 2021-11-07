package com.faraazs.votingserver.question;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController
{
	public static final String BASE_PATH = "/v1/questions";
	private QuestionService questionService;

	QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@GetMapping(BASE_PATH)
	public List<Question> getQuestions(@RequestHeader long sessionCode)
	{
		return questionService.list(sessionCode);
	}

	@GetMapping(BASE_PATH + "/current")
	public Question getCurrentQuestion(@RequestHeader long sessionCode)
	{
		return questionService.getLatest(sessionCode);
	}

	@PostMapping(BASE_PATH)
	public Question createQuestion(@RequestHeader long sessionCode, @RequestBody Question question)
	{
		return questionService.create(sessionCode, question);
	}
}