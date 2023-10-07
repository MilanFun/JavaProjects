import entity.User;
import service.UserService;

public class Main {
  public static void main(String[] args) {
    UserService userService = new UserService();

    User user = new User("Kirill", 15);
    userService.saveUser(user);
    userService.saveUser(new User("Linar", 21));
    userService.saveUser(new User("Vanya", 22));
  }
}
