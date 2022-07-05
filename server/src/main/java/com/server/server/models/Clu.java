package com.server.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String club_name;

    private Integer club_games;

    private Integer club_goals;

    private Integer club_points;

    public Clu(){}

    public Clu(String club_name, Integer club_games, Integer club_goals, Integer club_points) {
        this.club_name = club_name;
        this.club_games = club_games;
        this.club_goals = club_goals;
        this.club_points = club_points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubName() {
        return club_name;
    }

    public void setClubName(String club_name) {
        this.club_name = club_name;
    }

    public Integer getClubGames() {
        return club_games;
    }

    public void setClubGames(Integer club_games) {
        this.club_games = club_games;
    }

    public Integer getClubGoals() {
        return club_goals;
    }

    public void setClubGoals(Integer club_goals) {
        this.club_goals = club_goals;
    }

    public Integer getClubPoints() {
        return club_points;
    }

    public void setClubPoints(Integer club_points) {
        this.club_points = club_points;
    }


}
