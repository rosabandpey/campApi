package com.camp.campApi.modules.places.service.Impl;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.modules.places.repository.ChildPlaceRepo;
import com.camp.campApi.modules.places.repository.PlaceRepo;
import com.camp.campApi.modules.places.service.ChildPlaceService;
import com.camp.campApi.modules.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ChildPlaceServiceImpl implements ChildPlaceService {


    ChildPlaceRepo childPlaceRepo;
    PlaceRepo placeRepo;
    UserRepo userRepo;

    @Autowired
    public ChildPlaceServiceImpl(ChildPlaceRepo childPlaceRepo, PlaceRepo placeRepo, UserRepo userRepo) {
        this.childPlaceRepo = childPlaceRepo;
        this.placeRepo = placeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ChildPlace registerChildPlace(ChildPlace childPlace) {

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
