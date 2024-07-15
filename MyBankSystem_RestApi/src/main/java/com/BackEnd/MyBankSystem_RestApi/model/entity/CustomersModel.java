package com.BackEnd.MyBankSystem_RestApi.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String full_name;
    @Column
    private int age ;
    @Column
    private String address;
    @Column
    private String phone_number ;
    @Column
    private String gender;
    @Column
    private String role_name;
    @Column
    private boolean access;
    @Column
    private String pass;
    @Column
    private String user_name;
}
