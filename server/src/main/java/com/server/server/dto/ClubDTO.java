package com.server.server.dto;

import lombok.Data;

@Data
public class ClubDTO {

    private Long id;
    private String club_name;
    private Integer club_games;
    private Integer club_goals;
    private Integer club_points;

}
