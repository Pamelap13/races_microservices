package com.droipup.races_microservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubigeo_peru_departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departments {
    @Id
    private String id;
    private String name;
}
