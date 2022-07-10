package com.server.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.IOException;
import java.util.Collection;

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

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("club")
    private Collection<Player> players;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club1", fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Match> matches_first;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club2", fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Match> matches_second;

    public Club(){}

    public Club(String name, Integer games, Integer goals, Integer points) {
        this.name = name;
        this.games = games;
        this.goals = goals;
        this.points = points;
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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
    @JsonIgnore
    public Collection<Player> getPlayers() {
        return players;
    }
    @JsonIgnore
    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }
}
