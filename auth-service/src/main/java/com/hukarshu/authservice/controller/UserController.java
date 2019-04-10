package com.hukarshu.authservice.controller;

import com.hukarshu.authservice.domain.User;
import com.hukarshu.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/1 15:49
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/current",method = RequestMethod.PUT)
    public void saveUser(Principal principal,@Valid @RequestBody User user){
        userService.saveOne(principal.getName(),user);
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

}
