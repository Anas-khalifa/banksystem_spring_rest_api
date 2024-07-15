package com.BackEnd.MyBankSystem_RestApi.model.repository;

import com.BackEnd.MyBankSystem_RestApi.model.entity.authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authoritiesRepo extends JpaRepository<authorities,String> {
}
