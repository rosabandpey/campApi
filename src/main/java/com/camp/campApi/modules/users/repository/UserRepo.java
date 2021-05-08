package com.camp.campApi.modules.users.repository;

import com.camp.campApi.modules.users.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<AppUser,Long> {

    public AppUser findAppUserByUsername(String username);

    //@Query("select  appuser from AppUser appuser where appuser.id=:id")
    public AppUser findAppUserById(long id);



}
