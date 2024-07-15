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
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String Fullname;
    @Column
    private int AGE ;
    @Column
    private String address_;
    @Column
    private String Phone_Number ;
    @Column
    private String Gender;
    @Column
    private String role_name;
    @Column
    private boolean access;
    @Column
    private String pass;
    @Column
    private String user_name;
}
