package com.server.server.controllers;

import com.server.server.dto.ClubDTO;
import com.server.server.facade.ClubFacade;
import com.server.server.models.Clu;
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
    private final Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ibrazi10-");
    private final Statement statement = con.createStatement();

    public ClubController() throws SQLException {
    }


    @GetMapping("/club/all")
    public ResponseEntity<List<ClubDTO>> getAllClub(){
        List<Clu> clubs =(List<Clu>) clubRepository.findAll();
        List<ClubDTO> clubsDTO = clubs.stream().map(clubFacade::clubToClubDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(ClubDTO::getClub_points)))
                .collect(Collectors.toList());
        return new ResponseEntity<>(clubsDTO, HttpStatus.OK);
    }

    @PostMapping("/club/add")
    public void addClub(@RequestBody ClubDTO clubDTO){
        Clu newClub = new Clu(clubDTO.getClub_name(),
                                clubDTO.getClub_games(),
                                clubDTO.getClub_goals(),
                                clubDTO.getClub_points());
        clubRepository.save(newClub);
    }

    @GetMapping("/club/{id}")
    public ClubDTO clubById(@PathVariable(value ="id") long id){
        return clubFacade.clubToClubDTO(clubRepository.findById(id).orElseThrow());
    }

    @PostMapping("/club/delete/{id}")
    public void deleteClub(@PathVariable(value = "id") long id) throws SQLException {
        Clu deleteClub = clubRepository.findById(id).orElseThrow();
        clubRepository.delete(deleteClub);
        ResultSet result = statement.executeQuery("SELECT EXISTS(SELECT * FROM player WHERE club_id="+id+")");
        result.next();
        if(result.getBoolean("exists")){
            statement.executeUpdate("DELETE FROM player WHERE club_id=" + id);
        }
    }

    @PostMapping("/club/update")
    public void updateClub(@RequestBody ClubDTO clubDTO){
        Clu updateClub = clubRepository.findById(clubDTO.getId()).orElseThrow();
        updateClub.setClubName(clubDTO.getClub_name());
        updateClub.setClubGames(clubDTO.getClub_games());
        updateClub.setClubGoals(clubDTO.getClub_goals());
        updateClub.setClubPoints(clubDTO.getClub_points());
        clubRepository.save(updateClub);
    }
}
