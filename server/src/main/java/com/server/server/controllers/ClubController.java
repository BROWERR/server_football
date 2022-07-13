package com.server.server.controllers;

import com.server.server.dto.ClubDTO;
import com.server.server.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/club/all")
    public List<ClubDTO> getAllClub(){
        return clubService.getAllClubs();
    }

    @PostMapping("/club/add")
    public void addClub(@RequestBody ClubDTO clubDTO){
        clubService.addClub(clubDTO);
    }

    @GetMapping("/club/{id}")
    public ClubDTO clubById(@PathVariable(value ="id") long id){
       return clubService.getClubById(id);
    }

    @PostMapping("/club/delete/{id}")
    public void deleteClub(@PathVariable(value = "id") long id) {
       clubService.deleteClubById(id);
    }

    @PostMapping("/club/update")
    public void updateClub(@RequestBody ClubDTO clubDTO){
        clubService.updateClub(clubDTO);
    }
}
