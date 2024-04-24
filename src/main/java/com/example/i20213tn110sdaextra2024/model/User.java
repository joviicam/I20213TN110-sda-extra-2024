package com.example.i20213tn110sdaextra2024.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="user")
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Column(name ="name",length =30, nullable = false)
    String name;

    @Column(name="surname",length =30, nullable = false)
    String surname;

    @Column(name = "email",length =50, nullable = false)
    String email;

    @Column(name="bithdate", nullable = false)
    Date birthdate;

    @Column(name="password")
    String password;

    public User(String name, String surname, String email, Date birthdate, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.password = password;
    }
}
