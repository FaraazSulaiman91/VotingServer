package com.faraazs.votingserver.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController
{
	private SessionService sessionService;

	SessionController(SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	@GetMapping("/sessions/{code}")
	public Session getSession(@PathVariable long code)
	{
		return sessionService.findByCode(code);
	}

	@GetMapping("/sessions")
	public List<Session> getAllSession()
	{
		return sessionService.findAll();
	}

	@PostMapping("/sessions")
	public Session createSession()
	{
		return sessionService.create();
	}
}