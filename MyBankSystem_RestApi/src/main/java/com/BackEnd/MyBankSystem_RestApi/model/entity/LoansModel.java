package com.BackEnd.MyBankSystem_RestApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "loans")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoansModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loan_id;
    @Column
    private int account_id;
    @Column
    private String loan_type;
    @Column
    private int loan_amount;
    @Column
    private Date loan_start_date;
    @Column
    private Date loan_end_date;
    @Column
    private boolean active_state;

}
