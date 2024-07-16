package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.LoansModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.LoansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoansService {

    @Autowired
    LoansRepo loansRepo;

    public void LoansAdding(LoansModel loan){
        loansRepo.save(loan);
    }
    public void adimtLoan(LoansModel loan){
        LoansModel LoanToEdit=loansRepo.getReferenceById(loan.getLoan_id());

        Class<?> internClass= LoansModel.class;
        Field[] internFields=internClass.getDeclaredFields();

        for(Field field : internFields){

            field.setAccessible(true);
            Object value= null;
            try {
                value = field.get(loan);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if(value!=null){
                try {
                    field.set(LoanToEdit,value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }

        LoanToEdit.setActive_state(true);
        loansRepo.save(LoanToEdit);
    }

    public void remove(int id){
        loansRepo.deleteById(id);
    }

    public List<LoansModel> getLoans(int id){
        List<LoansModel> allLoans =new ArrayList<>();
        allLoans=loansRepo.findAll();
        for (LoansModel loan : allLoans){
            if(loan.getAccount_id()!=id)
                allLoans.remove(loan);
        }
        return allLoans;
    }
}
