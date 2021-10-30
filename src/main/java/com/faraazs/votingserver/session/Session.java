package com.faraazs.votingserver.session;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.ThreadLocalRandom;

@Entity(name = "sessions")
@Getter
@Setter
public class Session
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long code;

	public Session()
	{
		int lowerBound = 100000;
		int upperBound = 900000;
		code = ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
	}
}
