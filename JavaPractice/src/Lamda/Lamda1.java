package Lamda;

public class Lamda1 {
  public static void main(String[] args) {
    Expression func = n -> n % 2 == 0;
    System.out.println(sum(new int[]{1, 2, 3, 4, 5},  func));
  }

  public static int sum(int[] array, Expression func) {
    int result = 0;
    for(int i : array) {
      if(func.isEqual(i)) {
        result += i;
      }
    }

    return result;
  }
}

interface Expression {
  boolean isEqual(int n);
}
