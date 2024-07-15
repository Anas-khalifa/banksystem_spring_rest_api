package com.BackEnd.MyBankSystem_RestApi.controller;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransferModel;
import com.BackEnd.MyBankSystem_RestApi.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Transfer")
public class TransferController {
    @Autowired
    TransferService transferService;
    @PostMapping("/AddTransfer")
    public void AddingTransfer(@RequestBody TransferModel transfer){
        transferService.transferAdding(transfer);
    }
}
