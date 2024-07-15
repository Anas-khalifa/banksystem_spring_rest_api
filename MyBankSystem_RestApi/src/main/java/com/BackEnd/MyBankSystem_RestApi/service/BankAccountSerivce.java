package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.BankAccountModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;

@Service
public class BankAccountSerivce {
    @Autowired
    BankAccountRepo accountRepo;

    public void register(BankAccountModel account){
        accountRepo.save(account);
    }

//    public void update(BankAccountModel account){
//        BankAccountModel baseBankAccount=accountRepo.getReferenceById(account.getAccount_id());
//        int updatedBalance=account.getBalance();
//        if(account.getBalance()<0){
//            updatedBalance*=-1;
//            updatedBalance=baseBankAccount.getBalance()-updatedBalance;
//            if(updatedBalance<0)
//                return;
//        }
//        else updatedBalance=baseBankAccount.getBalance()+account.getBalance();
//
//        baseBankAccount.setAccount_id(account.getAccount_id());
//        baseBankAccount.setUser_id(account.getUser_id());
//        baseBankAccount.setBalance(updatedBalance);
//        accountRepo.save(baseBankAccount);
//    }

    public void balancePatcher(BankAccountModel account){
        BankAccountModel accountToEdit=accountRepo.getReferenceById(account.getAccount_id());

        Class<?> internClass= BankAccountModel.class;
        Field[] internFields=internClass.getDeclaredFields();

        for(Field field : internFields){

            field.setAccessible(true);
            Object value= null;
            try {
                value = field.get(account);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if(value!=null){
                try {
                    field.set(accountToEdit,value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }
        int updatedBalance=account.getBalance();
        if(account.getBalance()<0){
            updatedBalance*=-1;
            updatedBalance=accountToEdit.getBalance()-updatedBalance;
            if(updatedBalance<0)
                return;
        }
        else updatedBalance=accountToEdit.getBalance()+account.getBalance();

        accountToEdit.setBalance(updatedBalance);
        accountRepo.save(accountToEdit);
    }


}
