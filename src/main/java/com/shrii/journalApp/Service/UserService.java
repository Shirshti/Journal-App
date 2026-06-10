package com.shrii.journalApp.Service;

import com.shrii.journalApp.Entity.User;
import com.shrii.journalApp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    @Autowired
    JwtService jwtService;
    public User getByUsername(String username){
       return repo.findByUsername(username);
    }
    public String loginUsername(String username, String password){
         User user = repo.findByUsername(username);
        if(user == null)return "User Not Found";

        else{
            if(user.getPassword().equals(password)){
                return jwtService.generateToken(username);
            }
            else{
                return "Wrong Password";
            }
        }
    }
    public User saveUser(User user){
        return repo.save(user);
    }
}