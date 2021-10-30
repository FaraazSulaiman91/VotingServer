package com.faraazs.votingserver.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>
{
	@Query(value = "select u from sessions u where u.code = :code")
	Session findByCode(long code);
}
