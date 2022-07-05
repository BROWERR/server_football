package com.server.server.controllers;

import com.server.server.models.User;
import com.server.server.repository.ClubRepository;
import com.server.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("api/user/{id}")
    public User getUserById(@PathVariable(value="id") long id){
        return userService.getUserById(id);
    }

    @GetMapping("api/user/")
    public User getCurrentUser(Principal principal){
        return userService.getCurrentUser(principal);
    }
}
