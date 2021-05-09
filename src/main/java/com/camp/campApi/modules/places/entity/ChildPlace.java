package com.camp.campApi.modules.places.entity;

import com.camp.campApi.modules.users.entity.AppUser;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Table(name="child")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChildPlace implements Serializable {


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


    public ChildPlace() {
    }

    public ChildPlace(long id, String childName, String childLocation, String childDetails, String childCountry, String childCity, String childAddress, int childCellSignal, Date childLastVisit, int childCrowdness, int childManNoise, int childCleanness, int childSafty, int childWater, int childElectronic, int childShower, int childTrash, int childPicnicTable, int childToilet, int childWifi, int childFirePits, int childPetAllowed, int childADAaccessible) {
        this.id = id;
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

    public ChildPlace(long id, Place mychildplace, String childName, String childLocation, String childDetails, String childCountry, String childCity, String childAddress, int childCellSignal, Date childLastVisit, int childCrowdness, int childManNoise, int childCleanness, int childSafty, int childWater, int childElectronic, int childShower, int childTrash, int childPicnicTable, int childToilet, int childWifi, int childFirePits, int childPetAllowed, int childADAaccessible) {
        this.id = id;
        this.mychildplace = mychildplace;
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
    private int childCellSignal;

    private Date childLastVisit;

    @Column(nullable = false)
    private int childCrowdness;

    @Column(nullable = false)
    private int childManNoise;

    @Column(nullable = false)
    private int childCleanness;

    @Column(nullable = false)
    private int childSafty;

    @Column(nullable = false)
    private int childWater;

    @Column(nullable = false)
    private int childElectronic;

    @Column(nullable = false)
    private int childShower;

    @Column(nullable = false)
    private int childTrash;

    @Column(nullable = false)
    private int childPicnicTable;

    @Column(nullable = false)
    private int childToilet;

    @Column(nullable = false)
    private int childWifi;

    @Column(nullable = false)
    private int childFirePits;

    @Column(nullable = false)
    private int childPetAllowed;

    @Column(nullable = false)
    private int childADAaccessible;

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

    public int getChildCellSignal() {
        return childCellSignal;
    }

    public void setChildCellSignal(int childCellSignal) {
        this.childCellSignal = childCellSignal;
    }

    public Date getChildLastVisit() {
        return childLastVisit;
    }

    public void setChildLastVisit(Date childLastVisit) {
        this.childLastVisit = childLastVisit;
    }

    public int getChildCrowdness() {
        return childCrowdness;
    }

    public void setChildCrowdness(int childCrowdness) {
        this.childCrowdness = childCrowdness;
    }

    public int getChildManNoise() {
        return childManNoise;
    }

    public void setChildManNoise(int childManNoise) {
        this.childManNoise = childManNoise;
    }

    public int getChildCleanness() {
        return childCleanness;
    }

    public void setChildCleanness(int childCleanness) {
        this.childCleanness = childCleanness;
    }

    public int getChildSafty() {
        return childSafty;
    }

    public void setChildSafty(int childSafty) {
        this.childSafty = childSafty;
    }

    public int getChildWater() {
        return childWater;
    }

    public void setChildWater(int childWater) {
        this.childWater = childWater;
    }

    public int getChildElectronic() {
        return childElectronic;
    }

    public void setChildElectronic(int childElectronic) {
        this.childElectronic = childElectronic;
    }

    public int getChildShower() {
        return childShower;
    }

    public void setChildShower(int childShower) {
        this.childShower = childShower;
    }

    public int getChildTrash() {
        return childTrash;
    }

    public void setChildTrash(int childTrash) {
        this.childTrash = childTrash;
    }

    public int getChildPicnicTable() {
        return childPicnicTable;
    }

    public void setChildPicnicTable(int childPicnicTable) {
        this.childPicnicTable = childPicnicTable;
    }

    public int getChildToilet() {
        return childToilet;
    }

    public void setChildToilet(int childToilet) {
        this.childToilet = childToilet;
    }

    public int getChildWifi() {
        return childWifi;
    }

    public void setChildWifi(int childWifi) {
        this.childWifi = childWifi;
    }

    public int getChildFirePits() {
        return childFirePits;
    }

    public void setChildFirePits(int childFirePits) {
        this.childFirePits = childFirePits;
    }

    public int getChildPetAllowed() {
        return childPetAllowed;
    }

    public void setChildPetAllowed(int childPetAllowed) {
        this.childPetAllowed = childPetAllowed;
    }

    public int getChildADAaccessible() {
        return childADAaccessible;
    }

    public void setChildADAaccessible(int childADAaccessible) {
        this.childADAaccessible = childADAaccessible;
    }

    public AppUser getUserChildPlace() {
        return userChildPlace;
    }

    public void setUserChildPlace(AppUser userChildPlace) {
        this.userChildPlace = userChildPlace;
    }
}
