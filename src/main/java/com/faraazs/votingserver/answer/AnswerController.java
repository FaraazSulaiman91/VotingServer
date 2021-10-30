package com.faraazs.votingserver.answer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController
{
	private AnswerService answerService;

	AnswerController(AnswerService answerService)
	{
		this.answerService = answerService;
	}

	@GetMapping("/answers")
	public List<Answer> getAnswers(@RequestParam long questionId)
	{
		return answerService.findByQuestionId(questionId);
	}

	@PostMapping("/answers")
	public Answer createAnswer(@RequestBody Answer answer)
	{
		return answerService.createAnswer(answer);
	}

	@PostMapping("/answers/{id}")
	public Answer vote(@PathVariable long id)
	{
		return answerService.incrementVote(id);
	}
}