package com.camp.campApi.modules.places.service.Impl;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import com.camp.campApi.modules.places.entity.Place;
import com.camp.campApi.modules.places.repository.ChildPlaceRepo;
import com.camp.campApi.modules.places.repository.PlaceRepo;
import com.camp.campApi.modules.places.service.ChildPlaceResponseService;
import com.camp.campApi.modules.users.entity.AppUser;
import com.camp.campApi.modules.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Transactional
@Service
public class ChildPlaceResponseImpl implements ChildPlaceResponseService {

    @Autowired
    PlaceRepo placeRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ChildPlaceRepo childPlaceRepo;

    @Override
    public void registerChildPlace(ChildPlace childPlace, Principal principal) {
        Place place=placeRepo.findPlaceById(childPlace.getMychildplace());
        AppUser appUser=userRepo.findAppUserByUsername(principal.getName());
        ChildPlaceEntity childPlaceEntity=new ChildPlaceEntity();
        childPlaceEntity.setMychildplace(place);
        childPlaceEntity.setUserChildPlace(appUser);
        childPlaceEntity.setChildADAaccessible(childPlace.getChildADAaccessible());
        childPlaceEntity.setChildCity(childPlace.getChildCity());
        childPlaceEntity.setChildAddress(childPlace.getChildAddress());
        childPlaceEntity.setChildCleanness(childPlace.getChildCleanness());
        childPlaceEntity.setChildCountry(childPlace.getChildCountry());
        childPlaceEntity.setChildCellSignal(childPlace.getChildCellSignal());
        childPlaceEntity.setChildCrowdness(childPlace.getChildCrowdness());
        childPlaceEntity.setChildWifi(childPlace.getChildWifi());
        childPlaceEntity.setChildWater(childPlace.getChildWater());
        childPlaceEntity.setChildTrash(childPlace.getChildTrash());
        childPlaceEntity.setChildFirePits(childPlace.getChildFirePits());
        childPlaceEntity.setChildManNoise(childPlace.getChildManNoise());
        childPlaceEntity.setChildElectronic(childPlace.getChildElectronic());
        childPlaceEntity.setChildName(childPlace.getChildName());
        childPlaceEntity.setChildLastVisit(childPlace.getChildLastVisit());
        childPlaceEntity.setChildPetAllowed(childPlace.getChildPetAllowed());
        childPlaceEntity.setChildSafty(childPlace.getChildSafty());
        childPlaceEntity.setChildLocation(childPlace.getChildLocation());
        childPlaceEntity.setChildPicnicTable(childPlace.getChildPicnicTable());
        childPlaceEntity.setChildShower(childPlace.getChildShower());
        childPlaceEntity.setChildToilet(childPlace.getChildToilet());
        childPlaceRepo.save(childPlaceEntity);

    }



}
