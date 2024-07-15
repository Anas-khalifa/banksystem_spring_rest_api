package com.BackEnd.MyBankSystem_RestApi.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    @Column
    private int Balance;
    @Column
    private int user_id;
}
