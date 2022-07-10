package com.server.server.controllers;

import com.server.server.dto.PlayerDTO;
import com.server.server.facade.PlayerFacade;
import com.server.server.models.Player;
import com.server.server.repository.ClubRepository;
import com.server.server.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class PlayerController {
    @Autowired
    private PlayerFacade playerFacade;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ClubRepository clubRepository;

    public PlayerController() {
    }

    @GetMapping("/player/all/{id}")
    public Iterable<PlayerDTO> getAllClub(@PathVariable(value ="id") long id) throws SQLException {
        ArrayList<Player> playersList = (ArrayList<Player>) playerRepository.findPlayersByClub(clubRepository.findById(id));
        List<PlayerDTO> playersListDTO = playersList.stream().map(playerFacade::playerToPlayerDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(PlayerDTO::getGoals)))
                .collect(Collectors.toList());
        return playersListDTO;
    }

    @GetMapping("/player/{id}")
    public PlayerDTO playerById(@PathVariable(value ="id") long id){
        return playerFacade.playerToPlayerDTO(playerRepository.findById(id).orElseThrow());
    }

    @PostMapping("/player/delete/{id}")
    public void playerDelete(@PathVariable(value ="id") long id){
        Player deletePlayer = playerRepository.findById(id).orElseThrow();
        deletePlayer.setClub(null);
        playerRepository.delete(deletePlayer);
    }

    @PostMapping("/player/add")
    public void PlayerAdd(@RequestBody PlayerDTO playerDTO){
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

    @PostMapping("/player/update")
    public void updatePlayer(@RequestBody PlayerDTO playerDTO){
        Player updatePlayer = playerRepository.findById(playerDTO.getId()).orElseThrow();
        updatePlayer.setName(playerDTO.getName());
        updatePlayer.setSurname(playerDTO.getSurname());
        updatePlayer.setGames(playerDTO.getGames());
        updatePlayer.setGoals(playerDTO.getGoals());
        updatePlayer.setPosition(playerDTO.getPosition());
        updatePlayer.setClub(clubRepository.findById(playerDTO.getClub_id()).orElseThrow());
        playerRepository.save(updatePlayer);
    }
}
