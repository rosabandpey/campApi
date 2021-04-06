package com.camp.campApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="place")
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private long placeId;

    private String placeName;

    @OneToMany(mappedBy = "place")
    private Set<Place> parentName=new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="parent_id")
    private Place place;




}
