package com.camp.campApi.service.impl;

import com.camp.campApi.entity.ChildPlace;
import com.camp.campApi.repository.ChildPlaceRepo;
import com.camp.campApi.service.ChildPlaceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChildPlaceImpl implements ChildPlaceService {

    @Autowired
    ChildPlaceRepo childPlaceRepo;


    @Override
    public ChildPlace registerChildPlace(ChildPlace childPlace) {

        return  childPlaceRepo.save(childPlace);
    }

    @Override
    public ChildPlace updateChildPlace(long id) {
        ChildPlace childPlace=childPlaceRepo.updateChildPlaceById(id);
        return childPlace;
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
