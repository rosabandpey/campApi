package com.camp.campApi.repository;

import com.camp.campApi.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepo extends JpaRepository<Place,Long> {

    public static final String FIND_PLACENAME = "SELECT place_name FROM place";


    public Place findPlaceByPlaceName(String placeName);
    public Place findPlaceById(long id);

    @Query("select new Place(p.placeName) from Place p")
    public List<Place> findAllPlaceName();
}
