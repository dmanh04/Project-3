package com.javaweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="rentarea")
@Getter
@Setter
@NoArgsConstructor
public class RentAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="value")
    private Long value;

    @ManyToOne()
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;

}
