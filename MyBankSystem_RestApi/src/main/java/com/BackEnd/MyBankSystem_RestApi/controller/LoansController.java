package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.LoansModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.LoansRepo;
import com.BackEnd.MyBankSystem_RestApi.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Loans")
public class LoansController {

    @Autowired
    LoansService loansService;

    @GetMapping("/getLoan/{id}")
    public List<LoansModel> getLoan(@PathVariable int id){
        return loansService.getLoans(id);
    }

    @PostMapping("/AddLoan")
    public void addingLoan(@RequestBody LoansModel loan){
        loansService.LoansAdding(loan);
    }
    @PatchMapping("/admitLoan")
    public void adminLoan(@RequestBody LoansModel loan){
        loansService.adimtLoan(loan);
    }

    @DeleteMapping("/deleteLoan/{id}")
    public void remove(@PathVariable int id){
        loansService.remove(id);
    }
}
