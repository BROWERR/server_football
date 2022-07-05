package com.server.server.facade;

import com.server.server.dto.ClubDTO;
import com.server.server.models.Club;
import org.springframework.stereotype.Component;

@Component
public class ClubFacade {

    public ClubDTO clubToClubDTO(Club clu){
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setId(clu.getId());
        clubDTO.setName(clu.getName());
        clubDTO.setGames(clu.getGames());
        clubDTO.setGoals(clu.getGoals());
        clubDTO.setPoints(clu.getPoints());
        return clubDTO;
    }
}
