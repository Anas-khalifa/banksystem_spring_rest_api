package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.CustomersModel;
import com.BackEnd.MyBankSystem_RestApi.model.entity.authorities;
import com.BackEnd.MyBankSystem_RestApi.model.entity.users;
import com.BackEnd.MyBankSystem_RestApi.model.repository.authoritiesRepo;
import com.BackEnd.MyBankSystem_RestApi.model.repository.CustomersRepo;
import com.BackEnd.MyBankSystem_RestApi.model.repository.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    CustomersRepo customersRepo;

    @Autowired
    usersRepo userrepo;
    @Autowired
    authoritiesRepo userAuth;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private AuthenticationManager authenticationManager;

    public void register(CustomersModel user){
//        if(users_auth_repository.existByUsername(user.getUser_name())){
//            return new ResponseEntity<>("User is Taken", HttpStatus.BAD_REQUEST);
//        }
//        UsersModel usersModel= new UsersModel();
//
//        usersModel.setUser_name(user.getUser_name());
//        usersModel.setAge(user.getAge());
//        usersModel.setGender(user.getGender());
//        usersModel.setFull_name(user.getFull_name());
//        usersModel.setAccess(false);
//        usersModel.setAddress(user.getAddress());
//        usersModel.setPhone_number(user.getPhone_number());
//        usersModel.setRole_name(user.getRole_name());
//        usersModel.setPass(passwordEncoder.encode(user.getPass()));

//        users_auth_repository.save(u);

        customersRepo.save(user);
//

        users addUserToAuth=new users();
        addUserToAuth.setPassword("{noop}"+user.getPass());
        addUserToAuth.setEnabled(1);
        addUserToAuth.setUsername(user.getUser_name());
        userrepo.save(addUserToAuth);

        authorities a=new authorities();
        a.setUsername(user.getUser_name());
        a.setAuthority("ROLE_"+user.getRole_name().toUpperCase());
        userAuth.save(a);
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
