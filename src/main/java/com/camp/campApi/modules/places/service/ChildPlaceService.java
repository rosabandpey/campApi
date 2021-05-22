package com.camp.campApi.modules.places.service;

import com.camp.campApi.modules.places.entity.ChildPlaceEntity;

import java.util.List;


public interface ChildPlaceService {

    public ChildPlaceEntity registerChildPlace(ChildPlaceEntity childPlace);
    public ChildPlaceEntity updateChildPlace(long id, String name, String country);
    public List<ChildPlaceEntity> findAllChildPlace();
    public ChildPlaceEntity findChildPlaceByName(String childName);
    public ChildPlaceEntity findChildPlaceById(long id);
    public ChildPlaceEntity deleteChildPlace(long id);


}
