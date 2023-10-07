package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Age")
  private int age;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public User() {}
}
