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
    private int from_customer_id;
    @Column
    private int to_customer_id;
    @Column
    private int amount;
    @Column
    private Date transferDate;
}
