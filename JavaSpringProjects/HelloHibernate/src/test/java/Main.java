import entity.Goods;
import entity.User;
import service.GoodsService;
import service.UserService;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    UserService userService = new UserService();
    GoodsService goodsService = new GoodsService();

    userService.saveUser(new User("Michael", 13));
    userService.saveUser(new User("Linar", 21));
    userService.saveUser(new User("Vanya", 22));

    goodsService.saveGood(new Goods("iPhone1", 1));
    goodsService.saveGood(new Goods("iPhone2", 2));
    goodsService.saveGood(new Goods("iPhone2", 2));
    goodsService.saveGood(new Goods("iPhone3", 3));

    System.out.println();
  }
}
