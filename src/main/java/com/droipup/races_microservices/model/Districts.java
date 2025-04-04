package com.droipup.races_microservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubigeo_peru_districts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Districts {
    @Id
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Provinces provinces;
    @Column(name = "department_id")
    private String departmentId;
}
