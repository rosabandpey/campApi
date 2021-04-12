package com.camp.campApi.repository;

import com.camp.campApi.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place,Long> {


    public Place findPlaceByPlaceName(String placeName);
}
