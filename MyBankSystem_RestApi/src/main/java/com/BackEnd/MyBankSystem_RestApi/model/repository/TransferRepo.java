package com.BackEnd.MyBankSystem_RestApi.model.repository;

import com.BackEnd.MyBankSystem_RestApi.model.entity.TransferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepo extends JpaRepository<TransferModel,Integer> {
}
