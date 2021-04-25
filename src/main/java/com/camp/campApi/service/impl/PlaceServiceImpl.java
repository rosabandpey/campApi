package com.camp.campApi.service.impl;

import com.camp.campApi.entity.Place;
import com.camp.campApi.repository.PlaceRepo;
import com.camp.campApi.service.PlaceService;
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
        List<Place> places=placeRepo.findAllPlaceName();
        return places;
    }
}
