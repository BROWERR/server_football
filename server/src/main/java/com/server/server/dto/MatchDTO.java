package com.server.server.dto;

import com.server.server.models.Club;
import lombok.Data;

@Data
public class MatchDTO {
    private Long id;
    private Integer goals_first;
    private Integer goals_second;
    private String date;
    private Club club1;
    private Club club2;
}
