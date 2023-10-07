package com.example.springbootex.controller;

import com.example.springbootex.entity.User;
import com.example.springbootex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  public String findAll(Model model) {
    List<User> user = userService.findAll();
    model.addAttribute("users",user);
    return "user-list";
  }

  @GetMapping("/user-create")
  public String createUserForm(User user) {
    return "users-create";
  }

  @PostMapping("/user-create")
  public String createUser(User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }

  @GetMapping("/user-delete/{id}")
  public String deleteUser(@PathVariable("id") Long id) {
    userService.deleteById(id);
    return "redirect:/users";
  }

  @GetMapping("user-update/{id}")
  public String updateUserForm(@PathVariable("id") Long id, Model model) {
    User user = userService.findById(id);
    model.addAttribute("user", user);
    return "users-update";
  }

  @GetMapping("users-update")
  public String updateUser(User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }
}
