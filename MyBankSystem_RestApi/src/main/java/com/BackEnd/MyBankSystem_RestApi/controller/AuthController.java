package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.UsersModel;
import com.BackEnd.MyBankSystem_RestApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Authentication")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UsersModel user){
        authService.register(user);
    }
//    @PostMapping("/Login")
//    public ResponseEntity<String> login(@RequestBody UsersModel user){
//        if(authService.login(user))
//            return new ResponseEntity("logged in successfully ...", HttpStatus.OK);
//        return new ResponseEntity("logged in successfully ...", HttpStatus.BAD_REQUEST);
//    }

}
