package com.server.server.facade;

import com.server.server.dto.PlayerDTO;
import com.server.server.models.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerFacade {

    public PlayerDTO playerToPlayerDTO(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setSurname(player.getSurname());
        playerDTO.setPosition(player.getPosition());
        playerDTO.setGames(player.getGames());
        playerDTO.setGoals(player.getGoals());
        playerDTO.setClub(player.getClub());
        return playerDTO;
    }
}
