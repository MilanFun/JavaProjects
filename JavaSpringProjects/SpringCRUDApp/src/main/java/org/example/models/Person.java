package org.example.models;

import javax.validation.constraints.*;

public class Person {
  private int id;

  @NotEmpty(message = "Name should not be empty")
  @Size(min = 2, max = 10, message = "Name should be between 2 and 10 characters")
  private String name;

  @NotEmpty(message = "Surname should not be empty")
  @Size(min = 2, max = 15, message = "Surname should be between 2 and 15 characters")
  private String surname;

  @NotEmpty(message = "Email should not be empty")
  @Email(message = "Incorrect format of email")
  private String email;

  @Min(value = 0, message = "Age should be positive")
  @Max(value = 120, message = "Age should be real")
  private int age;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Person(int id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
  }

  public Person(int id, String name, String surname, String email, int age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Person() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getSurname() {
    return this.surname;
  }
}
