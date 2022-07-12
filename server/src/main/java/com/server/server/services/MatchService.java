package com.server.server.services;

import com.server.server.dto.MatchDTO;
import com.server.server.facade.MatchFacade;
import com.server.server.models.Match;
import com.server.server.repository.ClubRepository;
import com.server.server.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private MatchFacade matchFacade;
    public void deleteMatchById(Long id){
        Match deleteMatch = matchRepository.findById(id).orElseThrow();
        deleteMatch.setClub1(null);
        deleteMatch.setClub2(null);
        matchRepository.delete(deleteMatch);
    }

    public List<MatchDTO> getAllMatches(){
        List<Match> matches =(List<Match>) matchRepository.findAll();
        List<MatchDTO> matchesDTO = matches.stream().map(matchFacade::matchToMatchDTO)
                .collect(Collectors.toList());
        return matchesDTO;
    }

    public void addMatch(MatchDTO matchDTO){
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
