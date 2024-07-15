package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.CustomersModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class usersService {

    @Autowired
    CustomersRepo userrepo;

    //just to learn
    public CustomersModel getbyId(int id){
        return userrepo.getReferenceById(id);
    }

    public  void admitUser(CustomersModel user){
        CustomersModel UserToEdit=userrepo.getReferenceById(user.getId());

        Class<?> internClass= CustomersModel.class;
        Field[] internFields=internClass.getDeclaredFields();

        for(Field field : internFields){

            field.setAccessible(true);
            Object value= null;
            try {
                value = field.get(user);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if(value!=null){
                try {
                    field.set(UserToEdit,value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }
        UserToEdit.setAccess(true);
        userrepo.save(UserToEdit);
    }

    public void removeUser(int id){
        userrepo.deleteById(id);
    }
    public List<CustomersModel>getall(){
       return userrepo.findAll();
    }
}
