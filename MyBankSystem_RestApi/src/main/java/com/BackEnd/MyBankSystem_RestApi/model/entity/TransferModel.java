package com.BackEnd.MyBankSystem_RestApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transfers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transfer_id;
    @Column
    private int FromCustomerId;
    @Column
    private int ToCustomerId;
    @Column
    private int Amount;
    @Column
    private Date TransferDate;
}
