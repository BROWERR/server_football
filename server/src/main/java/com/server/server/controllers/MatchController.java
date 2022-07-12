package com.server.server.controllers;

import com.server.server.dto.MatchDTO;
import com.server.server.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/match/all")
    public List<MatchDTO> getAllMatches(){
        return matchService.getAllMatches();
    }

    @PostMapping("/match/delete")
    public void deleteMatch(@RequestBody long id){
        matchService.deleteMatchById(id);
    }

    @PostMapping("/match/add")
    public void matchAdd(@RequestBody MatchDTO matchDTO){
        matchService.addMatch(matchDTO);
    }
}
