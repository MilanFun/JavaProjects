package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "goods")
@Data
public class Goods {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;


  @ManyToMany(targetEntity = entity.User.class, mappedBy = "goods")
  private List<User> users;

  public Goods(String name) {
    this.name = name;
  }

  public Goods(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public Goods() {}
}
