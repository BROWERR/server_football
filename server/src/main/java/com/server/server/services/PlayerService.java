package com.server.server.services;

import com.server.server.Mapper.PlayerMapper;
import com.server.server.dto.PlayerDTO;
import com.server.server.models.Player;
import com.server.server.repository.ClubRepository;
import com.server.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private ClubRepository clubRepository;

    public Iterable<PlayerDTO> getAllPlayers(Long id){
        ArrayList<Player> playersList = (ArrayList<Player>) playerRepository.findPlayersByClub(clubRepository.findById(id));
        return playersList.stream().map(playerMapper::toPlayerDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(PlayerDTO::getGoals)))
                .collect(Collectors.toList());
    }

    public PlayerDTO getPlayerById(Long id){
        return playerMapper.toPlayerDTO(playerRepository.findById(id).orElseThrow());
    }

    public void playerDeleteById(Long id){
        Player deletePlayer = playerRepository.findById(id).orElseThrow();
        deletePlayer.setClub(null);
        playerRepository.delete(deletePlayer);
    }

    public void playerAdd(PlayerDTO playerDTO){
        Player newPlayer = new Player(
                playerDTO.getName(),
                playerDTO.getSurname(),
                playerDTO.getGames(),
                playerDTO.getGoals(),
                clubRepository.findById(playerDTO.getClub_id()).orElseThrow(),
                playerDTO.getPosition()
        );
        playerRepository.save(newPlayer);
    }

    public void playerUpdate(PlayerDTO playerDTO){
        Player updatePlayer = playerRepository.findById(playerDTO.getId()).orElseThrow();
        updatePlayer.setName(playerDTO.getName());
        updatePlayer.setSurname(playerDTO.getSurname());
        updatePlayer.setGames(playerDTO.getGames());
        updatePlayer.setGoals(playerDTO.getGoals());
        updatePlayer.setPosition(playerDTO.getPosition());
        playerRepository.save(updatePlayer);
    }
}
