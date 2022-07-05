package com.server.server.facade;

import com.server.server.dto.MatchDTO;
import com.server.server.models.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchFacade {
    public MatchDTO mathToMatchDTO(Match match){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setId(matchDTO.getId());
        matchDTO.setDate(matchDTO.getDate());
        matchDTO.setGoals_first(matchDTO.getGoals_first());
        matchDTO.setGoals_second(matchDTO.getGoals_second());
        matchDTO.setClub1(match.getClub1());
        matchDTO.setClub2(match.getClub2());
        return matchDTO;
    }
}
