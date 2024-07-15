package com.BackEnd.MyBankSystem_RestApi.model.repository;

import com.BackEnd.MyBankSystem_RestApi.model.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepo extends JpaRepository<users,Integer> {
}
