package com.server.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;
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
