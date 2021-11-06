package com.faraazs.votingserver.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController
{
	public static final String BASE_PATH = "/v1/sessions";
	private SessionService sessionService;

	SessionController(SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	@GetMapping(BASE_PATH + "/{code}")
	public Session getSession(@PathVariable long code)
	{
		return sessionService.findByCode(code);
	}

	@GetMapping(BASE_PATH)
	public List<Session> getAllSession()
	{
		return sessionService.findAll();
	}

	@PostMapping(BASE_PATH)
	public Session createSession()
	{
		return sessionService.create();
	}
}