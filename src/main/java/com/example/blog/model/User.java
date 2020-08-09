package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity      //  tworzy encje i mapuje ja na tabele
public class User {
    @Id         //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //auto-inkrementacja
    private long userId;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private LocalDateTime registrationDateTame;
    private boolean status;

}
