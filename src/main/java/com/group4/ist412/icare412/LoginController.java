/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import com.google.gson.Gson;
import java.util.List;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

/**
 *
 * @author leon
 */
public class LoginController {
    Gson gson;
    Nitrite db;
    Cursor cursor;
    ObjectRepository<User> userRepo;
    
    public LoginController() {
        gson = new Gson();
    }
    
    public boolean authenticate(String email, String password) {
        User user = userRepo.find(eq("email", email)).firstOrDefault();
        return user != null && user.getPassword().equals(password);
    }
    
    public User getUserByEmail(String email) {
        User user = userRepo.find(eq("email", email)).firstOrDefault();
        return user;
    }
    
    public String getUsers() {
        List<User> users = userRepo.find().toList();
        return gson.toJson(users);
    }
    
    public void setDb(Nitrite db) {
        this.db = db;
        this.userRepo = db.getRepository(User.class);
    }
}
