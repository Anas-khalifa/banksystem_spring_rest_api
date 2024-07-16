package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransactionModel;
import com.BackEnd.MyBankSystem_RestApi.model.entity.TransferModel;
import com.BackEnd.MyBankSystem_RestApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getTransaction/{id}")
    public List<TransactionModel> getT(@PathVariable int id){
        return transactionService.getTrans(id);
    }
}
