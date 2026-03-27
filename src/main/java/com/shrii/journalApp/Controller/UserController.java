package com.shrii.journalApp.Controller;


import com.shrii.journalApp.Entity.User;
import com.shrii.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
       return userService.loginUsername(user.getUsername(),user.getPassword());
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
