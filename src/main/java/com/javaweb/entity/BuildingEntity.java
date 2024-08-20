package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "street")
    private String street;
    @Column(name = "ward")
    private String ward;
    //	@Column(name="districtid")
//	private Integer districtid;
    @Column(name = "structure")
    private String structure;
    @Column(name = "numberofbasement")
    private Integer numberOfBasement;
    @Column(name = "floorarea")
    private Integer floorArea;
    @Column(name = "direction")
    private String direction;
    @Column(name = "level")
    private Integer level;
    @Column(name = "rentprice")
    private Integer rentprice;
    @Column(name = "rentpricedescription")
    private String rentpricedescription;
    @Column(name = "servicefee")
    private Integer servicefee;
    @Column(name = "carfee")
    private Integer carfee;
    @Column(name = "motofee")
    private Integer motorbikefee;
    @Column(name = "overtimefee")
    private Integer overtimefee;
    @Column(name = "waterfee")
    private Integer waterfee;
    @Column(name = "electricityfee")
    private Integer electricityfee;
    @Column(name = "deposit")
    private Integer deposit;
    @Column(name = "payment")
    private Integer payment;
    @Column(name = "renttime")
    private Integer renttime;
    @Column(name = "decorationtime")
    private Integer decorationtime;
    @Column(name = "brokeragefee")
    private Integer brokeragefee;
    @Column(name = "note")
    private String note;
    @Column(name = "linkofbuilding")
    private String linkofbuilding;
    @Column(name = "map")
    private String map;
    @Column(name = "createddate" , insertable = false, updatable = false)
    private Date createddate;
    @Column(name = "modifieddate" , insertable = false, updatable = false)
    private Date modifieddate;
    @Column(name = "managername")
    private String managerName;
    @Column(name = "managerphone")
    private Integer managerPhone;
    @Column(name = "createdby" , insertable = false, updatable = false)
    private String createdby;
    @Column(name = "modifiedby",  insertable = false, updatable = false)
    private String modifiedby;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentbuilding",
                joinColumns = @JoinColumn(name = "buildingid",nullable = false),
                inverseJoinColumns = @JoinColumn(name = "staffid",nullable = false))
    private List<UserEntity> userEntities = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRentprice() {
        return rentprice;
    }

    public void setRentprice(Integer rentprice) {
        this.rentprice = rentprice;
    }

    public String getRentpricedescription() {
        return rentpricedescription;
    }

    public void setRentpricedescription(String rentpricedescription) {
        this.rentpricedescription = rentpricedescription;
    }

    public Integer getServicefee() {
        return servicefee;
    }

    public void setServicefee(Integer servicefee) {
        this.servicefee = servicefee;
    }

    public Integer getCarfee() {
        return carfee;
    }

    public void setCarfee(Integer carfee) {
        this.carfee = carfee;
    }

    public Integer getMotorbikefee() {
        return motorbikefee;
    }

    public void setMotorbikefee(Integer motorbikefee) {
        this.motorbikefee = motorbikefee;
    }

    public Integer getOvertimefee() {
        return overtimefee;
    }

    public void setOvertimefee(Integer overtimefee) {
        this.overtimefee = overtimefee;
    }

    public Integer getWaterfee() {
        return waterfee;
    }

    public void setWaterfee(Integer waterfee) {
        this.waterfee = waterfee;
    }

    public Integer getElectricityfee() {
        return electricityfee;
    }

    public void setElectricityfee(Integer electricityfee) {
        this.electricityfee = electricityfee;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getRenttime() {
        return renttime;
    }

    public void setRenttime(Integer renttime) {
        this.renttime = renttime;
    }

    public Integer getDecorationtime() {
        return decorationtime;
    }

    public void setDecorationtime(Integer decorationtime) {
        this.decorationtime = decorationtime;
    }

    public Integer getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(Integer brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkofbuilding() {
        return linkofbuilding;
    }

    public void setLinkofbuilding(String linkofbuilding) {
        this.linkofbuilding = linkofbuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(Integer managerPhone) {
        this.managerPhone = managerPhone;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }
}