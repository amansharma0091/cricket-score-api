package com.test.iplapi.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface MatchDao extends CrudRepository<Match, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM matches WHERE date = :date")
	public List<Match> getMatchesOnDate(@Param("date") String date);

}
