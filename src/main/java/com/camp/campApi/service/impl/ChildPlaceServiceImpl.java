package com.camp.campApi.service.impl;

import com.camp.campApi.entity.ChildPlace;
import com.camp.campApi.repository.ChildPlaceRepo;
import com.camp.campApi.repository.PlaceRepo;
import com.camp.campApi.repository.UserRepo;
import com.camp.campApi.service.ChildPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ChildPlaceServiceImpl implements ChildPlaceService {

    @Autowired
    ChildPlaceRepo childPlaceRepo;

    @Autowired
    PlaceRepo placeRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ChildPlace registerChildPlace(ChildPlace childPlace,String placeName,String username) {


        childPlace.setMychildplace(placeRepo.findPlaceByPlaceName(placeName));
        childPlace.setUserChildPlace(userRepo.findAppUserByUsername(username));
    return  childPlaceRepo.save(childPlace);
    }

    @Override
    public ChildPlace updateChildPlace(long id, String name, String country) {
        ChildPlace place=childPlaceRepo.updateChildPlaceById(id,name,country);
        return place;
    }


    @Override
    public List<ChildPlace> findAllChildPlace() {
       List<ChildPlace> childPlaceList=childPlaceRepo.findAll();
       return childPlaceList;
    }

    @Override
    public ChildPlace findChildPlaceByName(String childName) {
        ChildPlace childPlace=childPlaceRepo.findChildPlaceByChildName(childName);
        return childPlace;
    }

    @Override
    public ChildPlace findChildPlaceById(long id) {
        ChildPlace childPlace=childPlaceRepo.findChildPlaceById(id);
        return childPlace;
    }

    @Override
    public ChildPlace deleteChildPlace(long id) {
        ChildPlace childPlace=childPlaceRepo.deleteChildPlaceById(id);
        return childPlace;
    }
}