package com.javaweb.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="building")
@Getter
@Setter
@NoArgsConstructor
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//

    @Column(name="name")
    private String name;//

    @Column(name="street")
    private String street;//

    @Column(name="ward")
    private String ward;//

    @Column(name="district")
    private String district;//

    @Column(name="structure")
    private String structure;//


    @Column(name="numberofbasement")
    private Long numberOfBasement;//


    @Column(name="floorarea")
    private Long floorArea;//


    @Column(name="direction")
    private Long direction;//

    @Column(name="level")
    private String level;//

    @Column(name="rentprice")
    private Long rentPrice;//

    @Column(name="rentpricedescription")
    private String rentPriceDESC;//

    @Column(name="servicefee")
    private String serviceFee;

    @Column(name="carfee")
    private String carFee;//

    @Column(name="motofee")
    private String motoFee;//

    @Column(name="overtimefee")
    private String overTimeFee;//

    @Column(name="waterfee")
    private String waterFee;//

    @Column(name="electricityfee")
    private String electricityFee;//

    @Column(name="deposit")
    private String deposit;//

    @Column(name="payment")
    private String payment;//

    @Column(name="renttime")
    private String rentTime;//

    @Column(name="decorationtime")
    private String decorationTime;//

    @Column(name="brokeragefee")
    private Double brokerageFee;//

    @Column(name="type")
    private String type;//

    @Column(name="note")
    private String note;//

    @Column(name="linkofbuilding")
    private String linkOfBuilding;//

    @Column(name="map")
    private String map;//

    @Column(name="avatar")
    private String avatar;//

    @Column(name="createddate")
    private Date createdDate;//

    @Column(name="modifieddate")
    private Date modifieDdate;//

    @Column(name="createdby")
    private String createdBy;//

    @Column(name="modifiedby")
    private String modifiedBy;//

    @Column(name="managername")
    private String managerName;//

    @Column(name="managerphone")
    private String managerPhone;//


    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreas = new ArrayList<>();

    @OneToMany(mappedBy = "building")
    private List<AssignmentBuildingEntity> assignmentBuildings = new ArrayList<>();
}
