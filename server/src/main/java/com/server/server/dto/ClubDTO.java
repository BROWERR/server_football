package com.server.server.dto;

import lombok.Data;

@Data
public class ClubDTO {

    private Long id;
    private String name;
    private Integer games;
    private Integer goals;
    private Integer points;

}
