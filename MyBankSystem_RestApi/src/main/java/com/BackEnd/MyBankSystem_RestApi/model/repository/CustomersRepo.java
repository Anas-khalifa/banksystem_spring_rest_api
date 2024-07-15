package com.BackEnd.MyBankSystem_RestApi.model.repository;

import com.BackEnd.MyBankSystem_RestApi.model.entity.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends JpaRepository<CustomersModel,Integer> {

}
