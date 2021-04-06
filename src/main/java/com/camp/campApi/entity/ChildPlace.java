package com.camp.campApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="childplace")
public class ChildPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="parentid")
    private Place place;


    private String name;

    private String location;

    private String details;

    private String country;

    private String city;

    private String address;

    private String cellSignal;

    private Date lastVisit;

    private int  crowdness;

    private int manNoise;

    private int  cleanness;

    private int  safty;

    private int  water;

    private int  electronic;

    private int  shower;

    private int  trash;

    private int  picnicTable;

    private int  toilet;

    private int  wifi;

    private int  firePits;

    private int  petAllowed;

    private int  ADAaccessible;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellSignal() {
        return cellSignal;
    }

    public void setCellSignal(String cellSignal) {
        this.cellSignal = cellSignal;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getCrowdness() {
        return crowdness;
    }

    public void setCrowdness(int crowdness) {
        this.crowdness = crowdness;
    }

    public int getManNoise() {
        return manNoise;
    }

    public void setManNoise(int manNoise) {
        this.manNoise = manNoise;
    }

    public int getCleanness() {
        return cleanness;
    }

    public void setCleanness(int cleanness) {
        this.cleanness = cleanness;
    }

    public int getSafty() {
        return safty;
    }

    public void setSafty(int safty) {
        this.safty = safty;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getElectronic() {
        return electronic;
    }

    public void setElectronic(int electronic) {
        this.electronic = electronic;
    }

    public int getShower() {
        return shower;
    }

    public void setShower(int shower) {
        this.shower = shower;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }

    public int getPicnicTable() {
        return picnicTable;
    }

    public void setPicnicTable(int picnicTable) {
        this.picnicTable = picnicTable;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getFirePits() {
        return firePits;
    }

    public void setFirePits(int firePits) {
        this.firePits = firePits;
    }

    public int getPetAllowed() {
        return petAllowed;
    }

    public void setPetAllowed(int petAllowed) {
        this.petAllowed = petAllowed;
    }

    public int getADAaccessible() {
        return ADAaccessible;
    }

    public void setADAaccessible(int ADAaccessible) {
        this.ADAaccessible = ADAaccessible;
    }


}


