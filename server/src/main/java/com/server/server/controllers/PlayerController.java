package com.server.server.controllers;

import com.server.server.dto.PlayerDTO;
import com.server.server.facade.PlayerFacade;
import com.server.server.models.Playe;
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
    private final Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ibrazi10-");
    private final Statement statement = con.createStatement();
    public PlayerController() throws SQLException {
    }

    @GetMapping("/player/all/{id}")
    public Iterable<PlayerDTO> getAllClub(@PathVariable(value ="id") long id) throws SQLException {
        ArrayList<Playe> playersList = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM player where club_id="+id);
        while (result.next()){
            Playe player = new Playe();
            player.setId(result.getLong("id"));
            player.setPlayerName(result.getString("player_name"));
            player.setPlayerSurname(result.getString("player_surname"));
            player.setPlayerGames(result.getInt("player_games"));
            player.setPlayerGoals(result.getInt("player_goals"));
            player.setPlayerPosition(result.getString("player_position"));
            player.setClubId(result.getInt("club_id"));
            playersList.add(player);
        }
        List<PlayerDTO> playersListDTO = playersList.stream().map(playerFacade::playerToPlayerDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(PlayerDTO::getPlayer_goals)))
                .collect(Collectors.toList());
        return playersListDTO;
    }

    @GetMapping("/player/{id}")
    public PlayerDTO playerById(@PathVariable(value ="id") long id){
        return playerFacade.playerToPlayerDTO(playerRepository.findById(id).orElseThrow());
    }

    @PostMapping("/player/delete/{id}")
    public void playerDelete(@PathVariable(value ="id") long id){
        Playe deletePlaye = playerRepository.findById(id).orElseThrow();
        playerRepository.delete(deletePlaye);
    }

    @PostMapping("/player/add")
    public void blogPostAdd(@RequestBody PlayerDTO playerDTO){
        Playe newPlayer = new Playe(
                playerDTO.getPlayer_name(),
                playerDTO.getPlayer_surname(),
                playerDTO.getPlayer_games(),
                playerDTO.getPlayer_goals(),
                playerDTO.getClub_id(),
                playerDTO.getPlayer_position()
        );
        playerRepository.save(newPlayer);
    }

    @PostMapping("/player/update")
    public void updatePlayer(@RequestBody PlayerDTO playerDTO){
        Playe updatePlayer = playerRepository.findById(playerDTO.getId()).orElseThrow();
        updatePlayer.setPlayerName(playerDTO.getPlayer_name());
        updatePlayer.setPlayerSurname(playerDTO.getPlayer_surname());
        updatePlayer.setPlayerGames(playerDTO.getPlayer_games());
        updatePlayer.setPlayerGoals(playerDTO.getPlayer_goals());
        updatePlayer.setPlayerPosition(playerDTO.getPlayer_position());
        updatePlayer.setClubId(playerDTO.getClub_id());
        playerRepository.save(updatePlayer);
    }
}
