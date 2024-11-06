package com.example.E_commerce.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private String password;
}
