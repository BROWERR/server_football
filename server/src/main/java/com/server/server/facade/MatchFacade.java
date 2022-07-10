package com.server.server.facade;

import com.server.server.dto.MatchDTO;
import com.server.server.models.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchFacade {
    public MatchDTO matchToMatchDTO(Match match){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(match.getId());
        matchDTO.setDate(match.getDate());
        matchDTO.setGoals_first(match.getGoals_first());
        matchDTO.setGoals_second(match.getGoals_second());
        matchDTO.setClub1(match.getClub1());
        matchDTO.setClub2(match.getClub2());
        return matchDTO;
    }
}
