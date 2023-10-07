package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
  private final JdbcTemplate jdbcTemplate;

  private static int PEOPLE_COUNT = 0;

  @Autowired
  public PersonDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Person> index() {
    return this.jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
  }

  public Person show(int id) {
    return this.jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id} , new BeanPropertyRowMapper<>(Person.class))
            .stream().findAny().orElse(null);
  }

  public void save(Person person) {
    this.jdbcTemplate.update("INSERT INTO person VALUES(1, ?, ?, ?, ?) ",
                              person.getName(), person.getSurname(), person.getAge(), person.getEmail());
  }

  public void update(int id, Person person) {
    this.jdbcTemplate.update("UPDATE person SET name=?, surname=?, age=?, email=? WHERE id=?",
                              person.getId(), person.getName(), person.getSurname(), person.getAge(), person.getEmail(), id);
  }

  public void delete(int id) {
    this.jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
  }
}
