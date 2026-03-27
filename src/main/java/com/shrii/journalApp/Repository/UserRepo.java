package com.shrii.journalApp.Repository;

import com.shrii.journalApp.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    User findByUsername(String username);


}
