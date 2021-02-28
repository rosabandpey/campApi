package com.camp.campApi.controller;


import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.exception.NotFoundException;
import com.camp.campApi.service.ResponseService;
import com.camp.campApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/authenticate")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?>  register(@RequestBody AppUser appUser) {

            AppUser user = userService.register(appUser);
            ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), user);
            return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }



    @GetMapping("/userList")
    //@Secured("ROLE_ADMIN")
   // @PreAuthorize("hasRole('ADMIN')")
    public List  userList() throws NotFoundException {

            List<AppUser> users=userService.findAllUser();
            return users;

    }

    @GetMapping("/getByUsername/{username}")

    public AppUser findUserByUsername(@PathVariable ("username") String username) {

        AppUser user=userService.findByUsername(username);

        return user;

    }




}
