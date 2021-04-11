package com.camp.campApi.repository;

import com.camp.campApi.entity.ChildPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChildPlaceRepo extends JpaRepository<ChildPlace,Long> {

    public ChildPlace findChildPlaceById(long id);

    public ChildPlace findChildPlaceByChildName(String name);

    public ChildPlace deleteChildPlaceById(long id);

    @Modifying
    @Query("update ChildPlace c set c.childName = ?1, c.childCountry = ?2 where c.id = ?3")
    public ChildPlace updateChildPlaceById(long id,String name,String country);

}
