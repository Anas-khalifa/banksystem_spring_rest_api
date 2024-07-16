package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransactionModel;
import com.BackEnd.MyBankSystem_RestApi.model.entity.TransferModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    public void transactionAdding(@RequestBody TransactionModel transaction){
        transactionRepo.save(transaction);
    }

    public List<TransactionModel> getTrans(int id){
        List<TransactionModel> allTransaction =new ArrayList<>();
        allTransaction=transactionRepo.findAll();
        for(TransactionModel t:allTransaction){
            if(t.getAccount_id()!=id){
                allTransaction.remove(t);
            }
        }

        return allTransaction;
    }
}
