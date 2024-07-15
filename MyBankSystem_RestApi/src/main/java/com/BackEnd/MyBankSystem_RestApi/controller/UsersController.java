package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.exceptionHandler.StudentNotFoundException;
import com.BackEnd.MyBankSystem_RestApi.model.entity.CustomersModel;
import com.BackEnd.MyBankSystem_RestApi.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    usersService userservice;
    //just for learning

    @GetMapping("/getAll")
    public List<CustomersModel>getall(){
        return userservice.getall();
    }
    @GetMapping("/getUser/{id}")
    public CustomersModel getUser(@PathVariable int id){

        try {
            CustomersModel u=userservice.getbyId(id);
            return u;
        }
        catch (StudentNotFoundException x){
            throw new StudentNotFoundException("User id not found - " + id);
        }
    }

    @PatchMapping("/ChangeUserAccessable")
    public void admitUserAccess(@RequestBody CustomersModel user){
        userservice.admitUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id){
        userservice.removeUser(id);
    }
}
