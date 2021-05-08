package com.camp.campApi.modules.places.service;

import com.camp.campApi.modules.places.entity.ChildPlace;

import java.util.List;


public interface ChildPlaceService {

    public ChildPlace registerChildPlace(ChildPlace childPlace);
    public ChildPlace updateChildPlace(long id,String name,String country);
    public List<ChildPlace> findAllChildPlace();
    public ChildPlace findChildPlaceByName(String childName);
    public ChildPlace findChildPlaceById(long id);
    public ChildPlace deleteChildPlace(long id);


}
