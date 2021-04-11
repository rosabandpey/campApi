package com.camp.campApi.controller;

import com.camp.campApi.entity.ChildPlace;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.service.ChildPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/childPlace")
public class ChildPlaceController {

    @Autowired
    ChildPlaceService childPlaceService;


    @PostMapping(value = "/savePlace/{placeName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> savePlace(@RequestBody ChildPlace childPlace,@PathVariable("placeName") String placeName)
    {
        ChildPlace place=childPlaceService.registerChildPlace(childPlace,placeName);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

    @GetMapping(value = "/findPlaceByName/{findPlaceByName}")
    public ResponseEntity<?> findPlaceByName(@PathVariable("findPlaceByName") String childName)
    {
        ChildPlace place=childPlaceService.findChildPlaceByName(childName);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

    @GetMapping(value = "/findAllPlaces")
    public ResponseEntity<?> findAllPlaces()
    {
        List<ChildPlace> places=childPlaceService.findAllChildPlace();
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(places) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }


    @DeleteMapping(value = "/deletePlace")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePlace(@PathVariable long id)
    {
        ChildPlace place=childPlaceService.deleteChildPlace(id);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }


    @PutMapping(value = "/updatePlace")
    public ResponseEntity<?> updatePlace(@PathVariable String childName,@PathVariable String country,@PathVariable long id)
    {
        ChildPlace place=childPlaceService.updateChildPlace(id,childName,country);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

}
