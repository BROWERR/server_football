package com.server.server.facade;

import com.server.server.dto.PlayerDTO;
import com.server.server.models.Playe;
import org.springframework.stereotype.Component;

@Component
public class PlayerFacade {

    public PlayerDTO playerToPlayerDTO(Playe player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setPlayer_name(player.getPlayerName());
        playerDTO.setPlayer_surname(player.getPlayerSurname());
        playerDTO.setPlayer_position(player.getPlayerPosition());
        playerDTO.setPlayer_games(player.getPlayerGames());
        playerDTO.setPlayer_goals(player.getPlayerGoals());
        playerDTO.setClub_id(player.getClubId());

        return playerDTO;
    }
}
