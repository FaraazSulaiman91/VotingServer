package com.faraazs.votingserver.answer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "answers")
@Getter
@Setter
@NoArgsConstructor
public class Answer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long questionId;
	private String text;
	private int voteCount;

	public void incrementVoteCount()
	{
		voteCount++;
	}
}
