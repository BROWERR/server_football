package com.server.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Playe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String player_name;

    private String player_surname;

    private String player_position;

    private Integer player_games;

    private Integer player_goals;

    private Integer club_id;

    public Playe(){}

    public Playe(String player_name, String player_surname,
                 Integer player_games, Integer player_goals,
                 Integer club_id, String player_position) {
        this.player_name = player_name;
        this.player_surname = player_surname;
        this.player_games = player_games;
        this.player_goals = player_goals;
        this.club_id = club_id;
        this.player_position = player_position;
    }

    public String getPlayerPosition() {
        return player_position;
    }

    public void setPlayerPosition(String player_position) {
        this.player_position = player_position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayerSurname() {
        return player_surname;
    }

    public void setPlayerSurname(String player_surname) {
        this.player_surname = player_surname;
    }

    public Integer getPlayerGames() {
        return player_games;
    }

    public void setPlayerGames(Integer player_games) {
        this.player_games = player_games;
    }

    public Integer getPlayerGoals() {
        return player_goals;
    }

    public void setPlayerGoals(Integer player_goals) {
        this.player_goals = player_goals;
    }

    public Integer getClubId() {
        return club_id;
    }

    public void setClubId(Integer club_id) {
        this.club_id = club_id;
    }


}
