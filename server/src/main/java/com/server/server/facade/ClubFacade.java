package com.server.server.facade;

import com.server.server.dto.ClubDTO;
import com.server.server.models.Clu;
import org.springframework.stereotype.Component;

@Component
public class ClubFacade {

    public ClubDTO clubToClubDTO(Clu clu){
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setId(clu.getId());
        clubDTO.setClub_name(clu.getClubName());
        clubDTO.setClub_games(clu.getClubGames());
        clubDTO.setClub_goals(clu.getClubGoals());
        clubDTO.setClub_points(clu.getClubPoints());
        return clubDTO;
    }
}
