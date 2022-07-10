package com.server.server.controllers;

import com.server.server.dto.ClubDTO;
import com.server.server.dto.MatchDTO;
import com.server.server.facade.MatchFacade;
import com.server.server.models.Club;
import com.server.server.models.Match;
import com.server.server.repository.ClubRepository;
import com.server.server.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class MatchController {
    @Autowired
    private MatchFacade matchFacade;
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/match/all")
    public ResponseEntity<List<MatchDTO>> getAllMatches(){
        List<Match> matches =(List<Match>) matchRepository.findAll();
        List<MatchDTO> matchesDTO = matches.stream().map(matchFacade::matchToMatchDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(matchesDTO, HttpStatus.OK);
    }

    @PostMapping("/match/delete")
    public void deleteClub(@RequestBody long id) throws SQLException {
        Match deleteMatch = matchRepository.findById(id).orElseThrow();
        deleteMatch.setClub1(null);
        deleteMatch.setClub2(null);
        matchRepository.delete(deleteMatch);
    }

    @PostMapping("/match/add")
    public void matchAdd(@RequestBody MatchDTO matchDTO){
        Match newMatch = new Match(
                matchDTO.getGoals_first(),
                matchDTO.getGoals_second(),
                matchDTO.getDate().substring(0,10),
                clubRepository.findById(matchDTO.getClub1().getId()).orElseThrow(),
                clubRepository.findById(matchDTO.getClub2().getId()).orElseThrow()
        );
        matchRepository.save(newMatch);
    }
}
