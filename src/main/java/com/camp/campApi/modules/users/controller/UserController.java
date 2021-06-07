package com.camp.campApi.modules.users.controller;


import com.camp.campApi.modules.places.entity.ChildPlaceEntity;
import com.camp.campApi.modules.users.entity.AppUser;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/authenticate")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?>  register(@RequestBody AppUser appUser) {

            AppUser user = userService.register(appUser);
            ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(user) );
            return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }

    @RequestMapping(value = "/updateProfile",method = {RequestMethod.GET,RequestMethod.POST},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?>  updateProfile(@RequestBody AppUser appUser) {

        AppUser user = userService.updateProfile(appUser);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), Arrays.asList(user) );
        return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }


    @GetMapping("/userList")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> userList()  {

            List<AppUser> users=userService.findAllUser();
            ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), users);
            return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<?> findUserByUsername(@PathVariable ("username") String username) {

        AppUser user=userService.findByUsername(username);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(),  Arrays.asList(user));
        return new ResponseEntity<>(responseApi,HttpStatus.OK);

    }


    @GetMapping(value = "/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable long id)
    {
        userService.deleteUserById(id);
        ResponseApi responseApi=new ResponseApi(true,HttpStatus.OK.toString(),new Date().toString(), null);
        return new ResponseEntity<>(responseApi,HttpStatus.OK );
    }


    @GetMapping(value = "/findUserById/{id}")
    public AppUser findUserById(@PathVariable("id")long id)
    {
        AppUser user=userService.findByUserId(id);
        return user;
    }


}
