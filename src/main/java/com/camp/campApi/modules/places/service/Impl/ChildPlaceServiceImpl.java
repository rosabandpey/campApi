package com.camp.campApi.modules.places.service.Impl;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import com.camp.campApi.modules.places.entity.Place;
import com.camp.campApi.modules.places.repository.ChildPlaceRepo;
import com.camp.campApi.modules.places.repository.PlaceRepo;
import com.camp.campApi.modules.places.service.ChildPlaceService;
import com.camp.campApi.modules.users.entity.AppUser;
import com.camp.campApi.modules.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Transactional
@Service
public class ChildPlaceServiceImpl implements ChildPlaceService {


    ChildPlaceRepo childPlaceRepo;
    PlaceRepo placeRepo;
    UserRepo userRepo;

    ChildPlaceEntity childPlaceEntity;

    @Autowired
    public ChildPlaceServiceImpl(ChildPlaceRepo childPlaceRepo, PlaceRepo placeRepo, UserRepo userRepo) {
        this.childPlaceRepo = childPlaceRepo;
        this.placeRepo = placeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ChildPlaceEntity registerChildPlace(ChildPlace childPlace, Principal principal) {

        AppUser appUser=userRepo.findAppUserByUsername(principal.getName());
        Place place=placeRepo.findPlaceById(childPlace.getMychildplace());

        if (childPlace.getId() == null)
        {
            childPlaceEntity=new ChildPlaceEntity();
        }
        else{
            childPlaceEntity.setId(childPlace.getId());
        }

        childPlaceEntity.setMychildplace(place);
        childPlaceEntity.setUserChildPlace(appUser);
        return  childPlaceRepo.save(childPlaceEntity);
    }

    @Override
    public ChildPlaceEntity updateChildPlace(long id, String name, String country) {
        ChildPlaceEntity place=childPlaceRepo.updateChildPlaceById(id,name,country);
        return place;
    }


    @Override
    public Page<ChildPlaceEntity> findAllChildPlace(Pageable pageable) {
       Page<ChildPlaceEntity> list=childPlaceRepo.findAll(pageable);
       return list;
    }

    @Override
    public ChildPlaceEntity findChildPlaceByName(String childName) {
        ChildPlaceEntity childPlace=childPlaceRepo.findChildPlaceByChildName(childName);
        return childPlace;
    }

    @Override
    public ChildPlaceEntity findChildPlaceById(long id) {
        ChildPlaceEntity childPlace=childPlaceRepo.findChildPlaceById(id);
        return childPlace;
    }

    @Override
    public void deleteChildPlace(long id) {
        childPlaceRepo.deleteById(id);

    }
}
