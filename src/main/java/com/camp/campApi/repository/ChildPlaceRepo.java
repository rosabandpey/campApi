package com.camp.campApi.repository;

import com.camp.campApi.entity.ChildPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildPlaceRepo extends JpaRepository<ChildPlace,Long> {

    public ChildPlace findChildPlaceById(long id);

    public ChildPlace findChildPlaceByChildName(String name);

    public ChildPlace deleteChildPlaceById(long id);

    public ChildPlace updateChildPlaceById(long id);

}
