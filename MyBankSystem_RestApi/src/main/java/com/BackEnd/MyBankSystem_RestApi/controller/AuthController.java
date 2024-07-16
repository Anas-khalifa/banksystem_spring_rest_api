package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.CustomersModel;
import com.BackEnd.MyBankSystem_RestApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Authentication")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public void registerUser(@RequestBody CustomersModel user){
        authService.register(user);
    }
    @PostMapping("/Login")
    public CustomersModel login(@RequestBody CustomersModel user){

        CustomersModel findUser= authService.login(user);
        if(findUser!=null)
            return findUser;
        return null;
    }
    @GetMapping("/usersFalseAccess")
    public List<CustomersModel> usersAccess(){
        return authService.usersWithAccessFalse();
    }

}
