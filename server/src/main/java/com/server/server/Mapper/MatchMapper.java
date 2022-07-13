package com.server.server.Mapper;

import com.server.server.dto.MatchDTO;
import com.server.server.models.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchDTO toMatchDTO(Match match);
}
