package com.camp.campApi.service.impl;

import com.camp.campApi.modules.users.entity.AppUser;
import com.camp.campApi.modules.users.entity.UserRole;
import com.camp.campApi.modules.users.repository.RoleRepo;
import com.camp.campApi.modules.users.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
@Transactional
public class UserDetaileServiceImpl implements UserDetailsService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=userRepo.findAppUserByUsername(username);
        if (appUser==null){
            throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserRole> userRoles = appUser.getUserRoles();


        userRoles.forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRoles.iterator().next().getRole().getRoleName()));
            System.out.println(userRoles.iterator().next().getRole().getRoleName());
        });
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);

    }
}
