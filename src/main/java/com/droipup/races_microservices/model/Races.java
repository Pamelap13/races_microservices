package com.droipup.races_microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "races")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Races {

    @Id
    private String id;
    private String name;
    private String description;
    private String organizer;
    @Column(name = "mode_id")
    private Integer modeId;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private Districts districts;
    @Column(name = "event_link")
    private String eventLink;
    @Column(name = "total_distance")
    private Double totalDistance;
    @Column(name = "total_elevation")
    private Double totalElevation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;


}
