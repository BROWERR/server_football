package com.server.server.repository;

import com.server.server.models.Club;
import com.server.server.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {
        List<Player> findPlayersByClub (Optional<Club> club);
}
