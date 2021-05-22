package com.camp.campApi.modules.places.controller;

import com.camp.campApi.modules.places.entity.ChildPlace;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.modules.places.entity.ChildPlaceResponse;
import com.camp.campApi.modules.places.entity.Place;
import com.camp.campApi.modules.places.service.ChildPlaceService;
import com.camp.campApi.modules.places.service.PlaceService;
import com.camp.campApi.modules.users.entity.AppUser;
import com.camp.campApi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/childPlace")
public class ChildPlaceController {


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

    @RequestMapping(value = "/savePlace",produces ={ MediaType.APPLICATION_JSON_VALUE},method = {RequestMethod.GET,RequestMethod.POST} )
    public ResponseEntity<?> savePlace(@RequestBody ChildPlaceResponse childPlaceResponse)  {

        Place place=placeService.findPlaceById(childPlaceResponse.getMychildplace());
        AppUser appUser=userService.findByUserId(childPlaceResponse.getUserChildPlace());
        ChildPlace childPlace=new ChildPlace();
        childPlace.setMychildplace(place);
        childPlace.setUserChildPlace(appUser);
        childPlace.setChildADAaccessible(childPlaceResponse.getChildADAaccessible());
        childPlace.setChildCity(childPlaceResponse.getChildCity());
        childPlace.setChildAddress(childPlaceResponse.getChildAddress());
        childPlace.setChildCleanness(childPlaceResponse.getChildCleanness());
        childPlace.setChildCountry(childPlaceResponse.getChildCountry());
        childPlace.setChildCellSignal(childPlaceResponse.getChildCellSignal());
        childPlace.setChildCrowdness(childPlaceResponse.getChildCrowdness());
        childPlace.setChildWifi(childPlaceResponse.getChildWifi());
        childPlace.setChildWater(childPlaceResponse.getChildWater());
        childPlace.setChildTrash(childPlaceResponse.getChildTrash());
        childPlace.setChildFirePits(childPlaceResponse.getChildFirePits());
        childPlace.setChildManNoise(childPlaceResponse.getChildManNoise());
        childPlace.setChildElectronic(childPlaceResponse.getChildElectronic());
        childPlace.setChildName(childPlaceResponse.getChildName());
        childPlace.setChildLastVisit(childPlaceResponse.getChildLastVisit());
        childPlace.setChildPetAllowed(childPlaceResponse.getChildPetAllowed());
        childPlace.setChildSafty(childPlaceResponse.getChildSafty());
        childPlace.setChildLocation(childPlaceResponse.getChildLocation());
        childPlace.setChildPicnicTable(childPlaceResponse.getChildPicnicTable());
        childPlace.setChildShower(childPlaceResponse.getChildShower());

        childPlace=childPlaceService.registerChildPlace(childPlace);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(childPlace) );
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
