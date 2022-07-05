package com.server.server.repository;

import com.server.server.models.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match,Long> {
}
