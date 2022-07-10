package com.server.server.controllers;

import com.server.server.dto.ClubDTO;
import com.server.server.facade.ClubFacade;
import com.server.server.models.Club;
import com.server.server.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ClubController {
    @Autowired
    private ClubFacade clubFacade;
    @Autowired
    private ClubRepository clubRepository;

    public ClubController() {
    }

    @GetMapping("/club/all")
    public ResponseEntity<List<ClubDTO>> getAllClub(){
        List<Club> clubs =(List<Club>) clubRepository.findAll();
        List<ClubDTO> clubsDTO = clubs.stream().map(clubFacade::clubToClubDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(ClubDTO::getPoints)))
                .collect(Collectors.toList());
        return new ResponseEntity<>(clubsDTO, HttpStatus.OK);
    }

    @PostMapping("/club/add")
    public void addClub(@RequestBody ClubDTO clubDTO){
        Club newClub = new Club(clubDTO.getName(),
                                clubDTO.getGames(),
                                clubDTO.getGoals(),
                                clubDTO.getPoints());
        clubRepository.save(newClub);
    }

    @GetMapping("/club/{id}")
    public ClubDTO clubById(@PathVariable(value ="id") long id){
        return clubFacade.clubToClubDTO(clubRepository.findById(id).orElseThrow());
    }

    @PostMapping("/club/delete/{id}")
    public void deleteClub(@PathVariable(value = "id") long id) throws SQLException {
        Club deleteClub = clubRepository.findById(id).orElseThrow();
        clubRepository.delete(deleteClub);
    }

    @PostMapping("/club/update")
    public void updateClub(@RequestBody ClubDTO clubDTO){
        Club updateClub = clubRepository.findById(clubDTO.getId()).orElseThrow();
        updateClub.setName(clubDTO.getName());
        updateClub.setGames(clubDTO.getGames());
        updateClub.setGoals(clubDTO.getGoals());
        updateClub.setPoints(clubDTO.getPoints());
        clubRepository.save(updateClub);
    }
}
