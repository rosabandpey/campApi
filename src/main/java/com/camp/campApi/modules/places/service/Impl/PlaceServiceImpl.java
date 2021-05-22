package com.camp.campApi.modules.places.service.Impl;

import com.camp.campApi.modules.places.entity.Place;
import com.camp.campApi.modules.places.repository.PlaceRepo;
import com.camp.campApi.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepo placeRepo;



    @Override
    public List<Place> findAllPlace() {
        List<Place> places=placeRepo.findAll();
        return places;
    }

    @Override
    public Place findPlaceById(long id) {
        Place place=placeRepo.findPlaceById(id);
        return place;
    }
}
