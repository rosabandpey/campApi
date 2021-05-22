package com.camp.campApi.modules.places.repository;

import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildPlaceRepo extends JpaRepository<ChildPlaceEntity,Long> {

    public ChildPlaceEntity findChildPlaceById(long id);

    public ChildPlaceEntity findChildPlaceByChildName(String name);

    public ChildPlaceEntity deleteChildPlaceById(long id);

    @Modifying
    @Query("update ChildPlaceEntity c set c.childName = ?1, c.childCountry = ?2 where c.id = ?3")
    public ChildPlaceEntity updateChildPlaceById(long id, String name, String country);

}
