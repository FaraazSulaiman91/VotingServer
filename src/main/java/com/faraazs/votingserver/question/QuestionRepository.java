package com.faraazs.votingserver.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>
{
	@Query("select q from questions q where q.sessionId = :sessionId")
	List<Question> findBySessionId(long sessionId);

	@Query("select q from questions q where q.sessionId = :sessionId order by q.id desc")
	Page<Question> getFindLatest(long sessionId, Pageable pageable);
}
