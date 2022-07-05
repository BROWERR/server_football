package com.server.server.dto;

import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private String player_name;
    private String player_surname;
    private String player_position;
    private Integer player_games;
    private Integer player_goals;
    private Integer club_id;
}
