package com.BackEnd.MyBankSystem_RestApi;

import com.BackEnd.MyBankSystem_RestApi.model.entity.LoansModel;
import com.BackEnd.MyBankSystem_RestApi.model.repository.LoansRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LonasServiceTest {
    @Mock
    private LoansRepo loansRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testOfLoansServiceTest(){
        LoansModel l= LoansModel.builder().build();

        LoansModel tester=loansRepo.save(l);


    }
}
