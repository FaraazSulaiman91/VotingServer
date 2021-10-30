package com.faraazs.votingserver.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>
{
	@Query("select a from answers a where a.questionId = :questionId")
	List<Answer> findByQuestionId(long questionId);
}
