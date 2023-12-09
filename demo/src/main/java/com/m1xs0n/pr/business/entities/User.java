package com.m1xs0n.pr.business.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username should contain only letters and digits")
    private String username;
    @Email(message = "Invalid email address")
    private String email;
}
