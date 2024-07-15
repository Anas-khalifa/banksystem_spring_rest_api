package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.exceptionHandler.StudentNotFoundException;
import com.BackEnd.MyBankSystem_RestApi.model.entity.UsersModel;
import com.BackEnd.MyBankSystem_RestApi.service.AuthService;
import com.BackEnd.MyBankSystem_RestApi.service.usersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    usersService userservice;
    //just for learning
    @GetMapping("/getUser/{id}")
    public UsersModel getUser(@PathVariable int id){

        try {
            UsersModel u=userservice.getbyId(id);
            return u;
        }
        catch (StudentNotFoundException x){
            throw new StudentNotFoundException("User id not found - " + id);
        }
    }

    @PatchMapping("/ChangeUserAccessable")
    public void admitUserAccess(@RequestBody UsersModel user){
        userservice.admitUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id){
        userservice.removeUser(id);
    }
}
