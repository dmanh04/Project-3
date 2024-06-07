package com.javaweb.entity;






import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="building")
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
    private String direction;//

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


    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<RentAreaEntity> rentAreas = new ArrayList<>();

//    @OneToMany(mappedBy = "building")
//    private List<AssignmentBuildingEntity> assignmentBuildings = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Long getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Long numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentPriceDESC() {
        return rentPriceDESC;
    }

    public void setRentPriceDESC(String rentPriceDESC) {
        this.rentPriceDESC = rentPriceDESC;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotoFee() {
        return motoFee;
    }

    public void setMotoFee(String motoFee) {
        this.motoFee = motoFee;
    }

    public String getOverTimeFee() {
        return overTimeFee;
    }

    public void setOverTimeFee(String overTimeFee) {
        this.overTimeFee = overTimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public Double getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public void setLinkOfBuilding(String linkOfBuilding) {
        this.linkOfBuilding = linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifieDdate() {
        return modifieDdate;
    }

    public void setModifieDdate(Date modifieDdate) {
        this.modifieDdate = modifieDdate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public List<RentAreaEntity> getRentAreas() {
        return rentAreas;
    }

    public void setRentAreas(List<RentAreaEntity> rentAreas) {
        this.rentAreas = rentAreas;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
