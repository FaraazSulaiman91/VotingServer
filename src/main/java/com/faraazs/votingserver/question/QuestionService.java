package com.faraazs.votingserver.question;

import com.faraazs.votingserver.session.SessionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService
{
	private QuestionRepository questionRepo;
	private SessionRepository sessionRepo;

	public QuestionService(QuestionRepository questionRepo, SessionRepository sessionRepo)
	{
		this.questionRepo = questionRepo;
		this.sessionRepo = sessionRepo;
	}

	public List<Question> list(long sessionCode)
	{
		long sessionId = resolveSessionId(sessionCode);
		return questionRepo.findBySessionId(sessionId);
	}

	public Question getLatest(long sessionCode)
	{
		long sessionId = resolveSessionId(sessionCode);
		return questionRepo.getFindLatest(sessionId, PageRequest.of(0, 1))
				.stream().findFirst().orElseThrow(() -> new RuntimeException("Cannot find question"));
	}

	public Question create(long sessionCode, Question question)
	{
		long sessionId = resolveSessionId(sessionCode);
		question.setSessionId(sessionId);
		return questionRepo.save(question);
	}

	private long resolveSessionId(long sessionCode)
	{
		return Optional.ofNullable(sessionRepo.findByCode(sessionCode)).orElseThrow(() -> new RuntimeException("No session found for code " + sessionCode)).getId();
	}
}