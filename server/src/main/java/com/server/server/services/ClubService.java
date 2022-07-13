package com.server.server.services;

import com.server.server.Mapper.ClubMapper;
import com.server.server.dto.ClubDTO;
import com.server.server.models.Club;
import com.server.server.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private ClubMapper clubMapper;

    public List<ClubDTO> getAllClubs(){
        List<Club> clubs =(List<Club>) clubRepository.findAll();
        return clubs.stream().map(clubMapper::toClubDTO)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(ClubDTO::getPoints)))
                .collect(Collectors.toList());
    }

    public void addClub(ClubDTO clubDTO){
        clubRepository.save(clubMapper.toClub(clubDTO));
    }

    public ClubDTO getClubById(Long id){
        return clubMapper.toClubDTO(clubRepository.findById(id).orElseThrow());
    }

    public void deleteClubById(Long id){
        clubRepository.delete(clubRepository.findById(id).orElseThrow());
    }

    public void updateClub(ClubDTO clubDTO){
        Club updateClub = clubRepository.findById(clubDTO.getId()).orElseThrow();
        updateClub.setName(clubDTO.getName());
        updateClub.setGames(clubDTO.getGames());
        updateClub.setGoals(clubDTO.getGoals());
        updateClub.setPoints(clubDTO.getPoints());
        clubRepository.save(updateClub);
    }
}
