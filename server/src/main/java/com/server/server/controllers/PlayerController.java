package com.server.server.controllers;

import com.server.server.dto.PlayerDTO;
import com.server.server.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player/all/{id}")
    public Iterable<PlayerDTO> getAllPlayers(@PathVariable(value ="id") long id){
        return playerService.getAllPlayers(id);
    }

    @GetMapping("/player/{id}")
    public PlayerDTO playerById(@PathVariable(value ="id") long id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("/player/delete/{id}")
    public void playerDelete(@PathVariable(value ="id") long id){
       playerService.playerDeleteById(id);
    }

    @PostMapping("/player/add")
    public void PlayerAdd(@RequestBody PlayerDTO playerDTO){
        playerService.playerAdd(playerDTO);
    }

    @PostMapping("/player/update")
    public void updatePlayer(@RequestBody PlayerDTO playerDTO){
        playerService.playerUpdate(playerDTO);
    }
}
