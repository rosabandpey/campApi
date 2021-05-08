package com.camp.campApi.modules.places.controller;

import com.camp.campApi.modules.places.entity.Place;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Places")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/placeList")
    public ResponseEntity<?> placeList()  {

        List<Place> places=placeService.findAllPlace();
        ResponseApi responseApi=new ResponseApi(true, HttpStatus.OK.toString(),new Date().toString(), places);
        return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }

    @GetMapping("/findPlace/{id}")
    public ResponseEntity<?> findPlace(@PathVariable("id") long id)  {

        Place place=placeService.findPlaceById(id);

        ResponseApi responseApi=new ResponseApi(true, HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place));
        return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }

}
