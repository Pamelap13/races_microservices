package com.droipup.races_microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "races_days")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RacesDays {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    private Races races;
    private Double distance;
    private Double elevation;
    @Column(name = "route_link")
    private String routeLink;
}
