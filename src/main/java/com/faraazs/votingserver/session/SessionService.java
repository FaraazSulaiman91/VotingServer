package com.faraazs.votingserver.session;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService
{
	private SessionRepository repository;

	public SessionService(SessionRepository repository)
	{
		this.repository = repository;
	}

	public Session findByCode(long code)
	{
		return repository.findByCode(code);
	}

	public Session create()
	{
		Session session = generateSession();
		repository.save(session);
		return session;
	}

	private Session generateSession()
	{
		Session session = new Session();

		while (repository.findByCode(session.getCode()) != null)
		{
			session = new Session();
		}
		return session;
	}

	public List<Session> findAll()
	{
		return repository.findAll();
	}
}