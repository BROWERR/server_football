package com.server.server.models;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer goals_first;

    private Integer goals_second;

    private String date;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_first_club")
    private Club club1;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_second_club")
    private Club club2;

    public Match(){
    }

    public Match(Integer goals_first,
                 Integer goals_second,
                 String date, Club club1, Club club2) {
        this.goals_first = goals_first;
        this.goals_second = goals_second;
        this.date = date;
        this.club1 = club1;
        this.club2 = club2;
    }
}
