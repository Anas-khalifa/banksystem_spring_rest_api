package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.UsersModel;
import com.BackEnd.MyBankSystem_RestApi.model.entity.authorities;
import com.BackEnd.MyBankSystem_RestApi.model.entity.users;
import com.BackEnd.MyBankSystem_RestApi.model.repository.authoritiesRepo;
import com.BackEnd.MyBankSystem_RestApi.model.repository.usersRepo;
import com.BackEnd.MyBankSystem_RestApi.model.repository.users_auth_repository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    usersRepo userrepo;
//    @Autowired
//    users_auth_repository usersAuthRepository;
//    @Autowired
//    authoritiesRepo userAuth;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private AuthenticationManager authenticationManager;

    public void register(UsersModel user){
//        if(userrepo.existsByUsername(user.getUsername())){
//            return false;
//        }
//        UsersModel usersModel= new UsersModel();
//
//        usersModel.setUsername(user.getUsername());
//        usersModel.setAGE(user.getAGE());
//        usersModel.setGender(user.getGender());
//        usersModel.setFullname(user.getFullname());
//        usersModel.setAccess(false);
//        usersModel.setAddress_(user.getAddress_());
//        usersModel.setPhone_Number(user.getPhone_Number());
//        usersModel.setRole_name(user.getRole_name());
//        usersModel.setPass(passwordEncoder.encode(user.getPass()));


        userrepo.save(user);
//        users u = new users();
//        u.setUsername(user.getUser_name());
//        u.setEnabled(1);
//
//        u.setPassword(user.getPass());
//        usersAuthRepository.save(u);
//
//        authorities a=new authorities();
//        a.setUsername(user.getUser_name());
//        a.setAuthority(user.getRole_name());
//        userAuth.save(a);

//        return true;
    }


//    public boolean login(UsersModel user){
//
//        Authentication authentication=authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUser_name(),user.getPass())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return true;
//    }
}
