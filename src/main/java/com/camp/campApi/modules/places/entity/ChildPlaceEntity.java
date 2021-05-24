package com.camp.campApi.modules.places.entity;

import com.camp.campApi.modules.users.entity.AppUser;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
//@Table(name="child")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChildPlaceEntity implements Serializable {


    private static final long serialVersionUID = -121838495708416147L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;


    @ManyToOne
   // @JsonIgnore
    @JoinColumn(name = "place_id",nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private Place mychildplace;


    @ManyToOne
   // @JsonIgnore
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private AppUser userChildPlace;


    public ChildPlaceEntity() {
    }


    public ChildPlaceEntity(long id, Place mychildplace, AppUser userChildPlace, String childName, String childLocation, String childDetails, String childCountry, String childCity, String childAddress, int childCellSignal, Date childLastVisit, int childCrowdness, int childManNoise, int childCleanness, int childSafty, int childWater, int childElectronic, int childShower, int childTrash, int childPicnicTable, int childToilet, int childWifi, int childFirePits, int childPetAllowed, int childADAaccessible) {
        this.id = id;
        this.mychildplace = mychildplace;
        this.userChildPlace = userChildPlace;
        this.childName = childName;
        this.childLocation = childLocation;
        this.childDetails = childDetails;
        this.childCountry = childCountry;
        this.childCity = childCity;
        this.childAddress = childAddress;
        this.childCellSignal = childCellSignal;
        this.childLastVisit = childLastVisit;
        this.childCrowdness = childCrowdness;
        this.childManNoise = childManNoise;
        this.childCleanness = childCleanness;
        this.childSafty = childSafty;
        this.childWater = childWater;
        this.childElectronic = childElectronic;
        this.childShower = childShower;
        this.childTrash = childTrash;
        this.childPicnicTable = childPicnicTable;
        this.childToilet = childToilet;
        this.childWifi = childWifi;
        this.childFirePits = childFirePits;
        this.childPetAllowed = childPetAllowed;
        this.childADAaccessible = childADAaccessible;
    }


    @Column(unique = true,nullable = false)
    private String childName;

    @Column(nullable = false)
    private String childLocation;

    private String childDetails;

    @Column(nullable = false)
    private String childCountry;

    @Column(nullable = false)
    private String childCity;

    @Column(nullable = false)
    private String childAddress;

    @Column(nullable = false)
    private Integer childCellSignal;

    private Date childLastVisit;

    @Column(nullable = false)
    private Integer childCrowdness;

    @Column(nullable = false)
    private Integer childManNoise;

    @Column(nullable = false)
    private Integer childCleanness;

    @Column(nullable = false)
    private Integer childSafty;

    @Column(nullable = false)
    private Integer childWater;

    @Column(nullable = false)
    private Integer childElectronic;

    @Column(nullable = false)
    private Integer childShower;

    @Column(nullable = false)
    private Integer childTrash;

    @Column(nullable = false)
    private int childPicnicTable;

    @Column(nullable = false)
    private Integer childToilet;

    @Column(nullable = false)
    private Integer childWifi;

    @Column(nullable = false)
    private Integer childFirePits;

    @Column(nullable = false)
    private Integer childPetAllowed;

    @Column(nullable = false)
    private Integer childADAaccessible;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Place getMychildplace() {
        return mychildplace;
    }

    public void setMychildplace(Place mychildplace) {
        this.mychildplace = mychildplace;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildLocation() {
        return childLocation;
    }

    public void setChildLocation(String childLocation) {
        this.childLocation = childLocation;
    }

    public String getChildDetails() {
        return childDetails;
    }

    public void setChildDetails(String childDetails) {
        this.childDetails = childDetails;
    }

    public String getChildCountry() {
        return childCountry;
    }

    public void setChildCountry(String childCountry) {
        this.childCountry = childCountry;
    }

    public String getChildCity() {
        return childCity;
    }

    public void setChildCity(String childCity) {
        this.childCity = childCity;
    }

    public String getChildAddress() {
        return childAddress;
    }

    public void setChildAddress(String childAddress) {
        this.childAddress = childAddress;
    }

    public Integer getChildCellSignal() {
        return childCellSignal;
    }

    public void setChildCellSignal(Integer childCellSignal) {
        this.childCellSignal = childCellSignal;
    }

    public Date getChildLastVisit() {
        return childLastVisit;
    }

    public void setChildLastVisit(Date childLastVisit) {
        this.childLastVisit = childLastVisit;
    }

    public Integer getChildCrowdness() {
        return childCrowdness;
    }

    public void setChildCrowdness(Integer childCrowdness) {
        this.childCrowdness = childCrowdness;
    }

    public Integer getChildManNoise() {
        return childManNoise;
    }

    public void setChildManNoise(Integer childManNoise) {
        this.childManNoise = childManNoise;
    }

    public Integer getChildCleanness() {
        return childCleanness;
    }

    public void setChildCleanness(Integer childCleanness) {
        this.childCleanness = childCleanness;
    }

    public Integer getChildSafty() {
        return childSafty;
    }

    public void setChildSafty(Integer childSafty) {
        this.childSafty = childSafty;
    }

    public Integer getChildWater() {
        return childWater;
    }

    public void setChildWater(Integer childWater) {
        this.childWater = childWater;
    }

    public Integer getChildElectronic() {
        return childElectronic;
    }

    public void setChildElectronic(Integer childElectronic) {
        this.childElectronic = childElectronic;
    }

    public Integer getChildShower() {
        return childShower;
    }

    public void setChildShower(Integer childShower) {
        this.childShower = childShower;
    }

    public Integer getChildTrash() {
        return childTrash;
    }

    public void setChildTrash(Integer childTrash) {
        this.childTrash = childTrash;
    }

    public Integer getChildPicnicTable() {
        return childPicnicTable;
    }

    public void setChildPicnicTable(Integer childPicnicTable) {
        this.childPicnicTable = childPicnicTable;
    }

    public Integer getChildToilet() {
        return childToilet;
    }

    public void setChildToilet(Integer childToilet) {
        this.childToilet = childToilet;
    }

    public Integer getChildWifi() {
        return childWifi;
    }

    public void setChildWifi(Integer childWifi) {
        this.childWifi = childWifi;
    }

    public Integer getChildFirePits() {
        return childFirePits;
    }

    public void setChildFirePits(Integer childFirePits) {
        this.childFirePits = childFirePits;
    }

    public Integer getChildPetAllowed() {
        return childPetAllowed;
    }

    public void setChildPetAllowed(Integer childPetAllowed) {
        this.childPetAllowed = childPetAllowed;
    }

    public Integer getChildADAaccessible() {
        return childADAaccessible;
    }

    public void setChildADAaccessible(Integer childADAaccessible) {
        this.childADAaccessible = childADAaccessible;
    }

    public AppUser getUserChildPlace() {
        return userChildPlace;
    }

    public void setUserChildPlace(AppUser userChildPlace) {
        this.userChildPlace = userChildPlace;
    }
}
