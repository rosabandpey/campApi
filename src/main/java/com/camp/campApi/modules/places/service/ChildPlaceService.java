package com.camp.campApi.modules.places.service;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;


public interface ChildPlaceService {

    public ChildPlaceEntity registerChildPlace(ChildPlace childPlace, Principal principal);
    public ChildPlaceEntity updateChildPlace(long id, String name, String country);
    public Page<ChildPlaceEntity> findAllChildPlace(int pageNo, int pageSize);
    public ChildPlaceEntity findChildPlaceByName(String childName);
    public ChildPlaceEntity findChildPlaceById(long id);
    public void deleteChildPlace(long id);


}
