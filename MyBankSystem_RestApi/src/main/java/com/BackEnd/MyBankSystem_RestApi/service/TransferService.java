package com.BackEnd.MyBankSystem_RestApi.service;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransferModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    TransferRepo transferRepo;

    public void transferAdding(TransferModel transfer){
        transferRepo.save(transfer);
    }
}
