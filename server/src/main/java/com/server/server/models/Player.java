package com.server.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Club club;

    public Player(){}

    public Player(String name, String surname,
                  Integer games, Integer goals,
                   Club club, String position) {
        this.name = name;
        this.surname = surname;
        this.games = games;
        this.goals = goals;
        this.club = club;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String player_position) {
        this.position = player_position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String player_name) {
        this.name = player_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String player_surname) {
        this.surname = player_surname;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer player_games) {
        this.games = player_games;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer player_goals) {
        this.goals = player_goals;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
