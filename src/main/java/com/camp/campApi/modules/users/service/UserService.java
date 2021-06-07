package com.camp.campApi.modules.users.service;

import com.camp.campApi.modules.users.entity.AppUser;

import java.util.List;


public interface UserService {

  public AppUser register(AppUser appUser);
  public AppUser updateProfile(AppUser appUser);
  public AppUser resetPassword();
  public List<AppUser> findAllUser();
  public AppUser findByUsername(String username);
  public AppUser findByUserId(long id);
  public void deleteUserById(long id);

}
