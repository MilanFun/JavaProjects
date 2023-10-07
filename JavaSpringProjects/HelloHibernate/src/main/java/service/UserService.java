package service;

import dao.UserDAO;
import entity.Goods;
import entity.User;

import java.util.List;

public class UserService {
  private final UserDAO userDAO = new UserDAO();

  public UserService() {

  }

  public User findUser(Long id) {
    return this.userDAO.findById(id);
  }

  public void saveUser(User user) {
    this.userDAO.save(user);
  }

  public void deleteUser(User user) {
    this.userDAO.delete(user);
  }

  public void updateUser(User user) {
    this.userDAO.update(user);
  }

}
