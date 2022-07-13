package com.server.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Data
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
}
