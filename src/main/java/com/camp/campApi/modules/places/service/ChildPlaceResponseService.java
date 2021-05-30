package com.camp.campApi.modules.places.service;

import com.camp.campApi.modules.places.entity.ChildPlace;

import java.security.Principal;

public interface ChildPlaceResponseService {

    public void registerChildPlace(ChildPlace childPlace, Principal principal);
}
