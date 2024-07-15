package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransactionModel;
import com.BackEnd.MyBankSystem_RestApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/AddTransaction")
    public void addTransaction(@RequestBody TransactionModel transaction){
        transactionService.transactionAdding(transaction);
    }
}
