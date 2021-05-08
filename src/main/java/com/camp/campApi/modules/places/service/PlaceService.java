package com.camp.campApi.modules.places.service;

import com.camp.campApi.modules.places.entity.Place;

import java.util.List;

public interface PlaceService {

    public List<Place> findAllPlace();
    public Place findPlaceById(long id);
}
