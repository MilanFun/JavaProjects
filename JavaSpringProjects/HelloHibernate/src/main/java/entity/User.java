package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Age")
  private int age;

  @ManyToMany(targetEntity = entity.Goods.class)
  private List<Goods> goods;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public User() {}
}
