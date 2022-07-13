package com.server.server.Mapper;

import com.server.server.dto.ClubDTO;
import com.server.server.models.Club;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubDTO toClubDTO(Club club);

    Club toClub(ClubDTO clubDTO);
}
