package com.camp.campApi.modules.places.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="place")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Place implements Serializable {

    private static final long serialVersionUID = -121838495708416152L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String placeName;


    @Column(nullable = false)
    private String parentName;

    @OneToMany(mappedBy = "place")
    @JsonIgnore
    private Set<Place> parent=new HashSet<>();


    @OneToMany(mappedBy = "mychildplace")
    private Set<ChildPlaceEntity> mychildplace=new HashSet<>();


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="parent_id",nullable = false)
    private Place place;


    public Place() {
    }

    public Place(String placeName) {
        this.placeName = placeName;
    }

    public Place(long id, String placeName, String parentName, Set<Place> parent, Place place) {
        this.id = id;
        this.placeName = placeName;
        this.parentName = parentName;
        this.parent = parent;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Set<Place> getParent() {
        return parent;
    }

    public void setParent(Set<Place> parent) {
        this.parent = parent;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
