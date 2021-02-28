package com.camp.campApi.service.impl;

import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.UserRole;
import com.camp.campApi.exception.ApiException;
import com.camp.campApi.exception.NotFoundException;
import com.camp.campApi.repository.RoleRepo;
import com.camp.campApi.repository.UserRepo;
import com.camp.campApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override

    public AppUser register(AppUser appUser) {

        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setUserRoles(new UserRole(appUser,roleRepo.findRoleByRoleName("USER")));
        AppUser userEmail = userRepo.findAppUserByUsername(appUser.getUsername());
        if (userEmail!=null ){
            throw new ApiException("User Exists");
        } else {
            userRepo.save(appUser);
        }

        return appUser;
    }

    @Override
    public AppUser updateProfile() {
        return  null;
    }

    @Override
    public AppUser resetPassword() {
        return null;
    }

    @Override
    public List<AppUser> findAllUser() {
       List<AppUser> users= userRepo.findAll();
       if (users==null) throw new NotFoundException("List Is Empty ,there is no User");
       return users;
    }

    @Override
    public AppUser findByUsername(String username) {
        AppUser user=userRepo.findAppUserByUsername(username);
        if (user==null) throw new NotFoundException("User Not Found By Username  "+username);
        return user;
    }

    @Override
    public AppUser findByUserId(long id) {
        AppUser user=userRepo.findAppUserById(id);
        if (user==null) throw new NotFoundException("User Not Found By Username  "+id);
        return user;
    }


}
