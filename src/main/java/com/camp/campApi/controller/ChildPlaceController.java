package com.camp.campApi.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.ChildPlace;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.security.SecurityConstants;
import com.camp.campApi.service.ChildPlaceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/childPlace")
public class ChildPlaceController {

    @Autowired
    ChildPlaceService childPlaceService;




    @RequestMapping(value = "/savePlace/{username}/{placeName}",produces ={ MediaType.APPLICATION_JSON_VALUE},method = {RequestMethod.GET,RequestMethod.POST} )
    public ResponseEntity<?> savePlace(@RequestBody ChildPlace childPlace, @PathVariable("placeName") String placeName, @PathVariable("username") String username)  {
        ChildPlace place=childPlaceService.registerChildPlace(childPlace,placeName,username);
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
