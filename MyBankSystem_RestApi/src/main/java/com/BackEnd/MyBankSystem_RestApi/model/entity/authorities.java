package com.BackEnd.MyBankSystem_RestApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class authorities {
    @Id
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "authority")
    private String authority;

}
