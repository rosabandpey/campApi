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


    @PostMapping(value = "/savePlace")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> savePlace(@RequestBody ChildPlace childPlace)
    {
        ChildPlace place=childPlaceService.registerChildPlace(childPlace);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

    @GetMapping(value = "/findPlaceByName")
    public ResponseEntity<?> findPlaceByName(@PathVariable String childName)
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


}
