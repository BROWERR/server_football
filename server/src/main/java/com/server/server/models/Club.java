package com.server.server.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer games;

    private Integer goals;

    private Integer points;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER, orphanRemoval = true)
    private Collection<Player> players;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club1", fetch = FetchType.EAGER, orphanRemoval = true)
    private Collection<Match> matches_first;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "club2", fetch = FetchType.EAGER, orphanRemoval = true)
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

    public String getClubName() {
        return name;
    }

    public void setClubName(String name) {
        this.name = name;
    }

    public Integer getClubGames() {
        return games;
    }

    public void setClubGames(Integer games) {
        this.games = games;
    }

    public Integer getClubGoals() {
        return goals;
    }

    public void setClubGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getClubPoints() {
        return points;
    }

    public void setClubPoints(Integer points) {
        this.points = points;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }
}
