package com.server.server.Mapper;

import com.server.server.dto.PlayerDTO;
import com.server.server.models.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerDTO toPlayerDTO(Player player);
}
