package com.example.api.controller;

import com.example.api.entity.User;
import com.example.api.error.UserExistsException;
import com.example.api.error.UserNotFoundException;
import com.example.api.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public User registerUser(@RequestBody User newUser) throws UserExistsException {
        return  userService.registerUser(newUser);
    }


    @GetMapping("/email/{email}")
    public  User fetchUserByEmail(@PathVariable("email") String email) throws UserNotFoundException {
        return  userService.findUserByEmail(email);
    }


}
