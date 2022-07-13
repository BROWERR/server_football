package com.server.server.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    private Integer games;

    private Integer goals;

    private Integer points;

    public Club(String name, Integer games, Integer goals, Integer points) {
        this.name = name;
        this.games = games;
        this.goals = goals;
        this.points = points;
    }

    public Club() {
    }
}
