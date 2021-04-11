package com.camp.campApi.service;

import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.ChildPlace;

import java.util.List;


public interface ChildPlaceService {

    public ChildPlace registerChildPlace(ChildPlace childPlace,String placeName);
    public ChildPlace updateChildPlace(long id,String name,String country);
    public List<ChildPlace> findAllChildPlace();
    public ChildPlace findChildPlaceByName(String childName);
    public ChildPlace findChildPlaceById(long id);
    public ChildPlace deleteChildPlace(long id);


}
