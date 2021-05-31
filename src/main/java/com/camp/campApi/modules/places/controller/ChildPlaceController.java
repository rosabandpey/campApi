package com.camp.campApi.modules.places.controller;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.modules.places.service.ChildPlaceResponseService;
import com.camp.campApi.modules.places.service.ChildPlaceService;
import com.camp.campApi.modules.places.service.PlaceService;
import com.camp.campApi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/childPlace")
public class ChildPlaceController {


    @Autowired
    ChildPlaceResponseService childPlaceResponseService;

    ChildPlaceService childPlaceService;
    PlaceService placeService;
    UserService userService;

    public ChildPlaceController(ChildPlaceService childPlaceService, PlaceService placeService) {
        this.childPlaceService = childPlaceService;
        this.placeService = placeService;
    }

    @Autowired
    public ChildPlaceController(ChildPlaceService childPlaceService) {
        this.childPlaceService = childPlaceService;
    }

    @RequestMapping(value = "/savePlace",produces ={ MediaType.APPLICATION_JSON_VALUE},method = {RequestMethod.POST} )
    public ResponseEntity<?> savePlace(@RequestBody ChildPlace childPlace, Principal principal)  {

        System.out.println(principal.getName());
        childPlaceResponseService.registerChildPlace(childPlace,principal);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(childPlace) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }




    @GetMapping(value = "/findPlaceByName/{findPlaceByName}")
    public ResponseEntity<?> findPlaceByName(@PathVariable("findPlaceByName") String childName)
    {
        ChildPlaceEntity place=childPlaceService.findChildPlaceByName(childName);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

    @GetMapping(value = "/findAllPlaces")
    public ResponseEntity<?> findAllPlaces()
    {
        List<ChildPlaceEntity> places=childPlaceService.findAllChildPlace();
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), places );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }


    @GetMapping(value = "/findPlaceById/{id}")
    public ChildPlaceEntity findPlaceById(@PathVariable("id")long id)
    {
        ChildPlaceEntity place=childPlaceService.findChildPlaceById(id);
        return place;
    }


    @GetMapping(value = "/deletePlace/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletePlace(@PathVariable long id)
    {
        childPlaceService.deleteChildPlace(id);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), null);
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }


    @PutMapping(value = "/updatePlace")
    public ResponseEntity<?> updatePlace(@PathVariable String childName,@PathVariable String country,@PathVariable long id)
    {
        ChildPlaceEntity place=childPlaceService.updateChildPlace(id,childName,country);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(place) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }

}
