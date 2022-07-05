package com.server.server.dto;

import com.server.server.models.Club;
import lombok.Data;

@Data
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private String position;
    private Integer games;
    private Integer goals;
    private Club club;
}
