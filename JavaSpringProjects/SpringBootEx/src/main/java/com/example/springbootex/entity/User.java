package com.example.springbootex.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "accounts")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;
}
