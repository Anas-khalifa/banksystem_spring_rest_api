package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.BankAccountModel;
import com.BackEnd.MyBankSystem_RestApi.service.BankAccountSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/Account")
public class BankAccountController {
    @Autowired
    BankAccountSerivce accountSerivce;

    @PostMapping("/AddAccount")
    public void addAccount(@RequestBody BankAccountModel accountData){
        accountSerivce.register(accountData);
    }
    @PatchMapping("/update_balance_deposit")
    public void updateBalance(@RequestBody BankAccountModel accountData){
        accountSerivce.balancePatcher(accountData);
    }
}
