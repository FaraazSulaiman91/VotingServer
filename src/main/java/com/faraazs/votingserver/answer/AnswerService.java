package com.faraazs.votingserver.answer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService
{
	private AnswerRepository repository;

	public AnswerService(AnswerRepository repository)
	{
		this.repository = repository;
	}

	public List<Answer> findByQuestionId(long questionId)
	{
		return repository.findByQuestionId(questionId);
	}

	public List<Answer> findAll()
	{
		return repository.findAll();
	}

	public Answer createAnswer(Answer answer)
	{
		return repository.save(answer);
	}

	public Answer incrementVote(long id)
	{
		Answer answer = repository.findById(id).orElseThrow(() -> new RuntimeException("No answer found for Id " + id));
		answer.incrementVoteCount();
		return repository.save(answer);
	}
}