package com.droipup.races_microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubigeo_peru_provinces")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provinces {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Departments departments;

}
