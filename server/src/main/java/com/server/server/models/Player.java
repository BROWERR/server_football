package com.server.server.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String position;

    private Integer games;

    private Integer goals;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id")
    private Club club;

    public Player(){}

    public Player(String name, String surname,
                  Integer games, Integer goals,
                  Long club_id, String position) {
        this.name = name;
        this.surname = surname;
        this.games = games;
        this.goals = goals;
        this.club.setId(club_id);
        this.position = position;
    }

    public String getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(String player_position) {
        this.position = player_position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String player_name) {
        this.name = player_name;
    }

    public String getPlayerSurname() {
        return surname;
    }

    public void setPlayerSurname(String player_surname) {
        this.surname = player_surname;
    }

    public Integer getPlayerGames() {
        return games;
    }

    public void setPlayerGames(Integer player_games) {
        this.games = player_games;
    }

    public Integer getPlayerGoals() {
        return goals;
    }

    public void setPlayerGoals(Integer player_goals) {
        this.goals = player_goals;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
