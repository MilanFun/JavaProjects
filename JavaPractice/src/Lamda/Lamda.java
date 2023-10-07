package Lamda;

public class Lamda {
  static int x = 10;
  static int y = 20;

  public static void main(String[] args) {
    int x1 = 10, y1 = 20;
    CalculateSum check = (x, y) -> x + y;
    int z = check.calculate(x1, y1);
    System.out.println(z);

    Printable p = s -> System.out.println(s);
    String hello = "Hello, Java";
    p.print(hello);

    Operation o = () -> {
      x += 20;
      return x + y;
    };

    CalculateSum devision = (x, y) -> {
      try {
        return x/y;
      } catch (ArithmeticException e) {
        y += 1;
        return x/y;
      }
    };

    System.out.println(devision.calculate(10, 0));
    System.out.println(devision.calculate(10, 10));

    System.out.println(x + " before\n" + "x after calculate " + o.calculate() + " " + x);

    Generic<String> g1 = (x, y) -> x + y;
    Generic<Integer> g2 = (x, y) -> x + y;

    System.out.println(g1.calculate("Hello, ", "World!"));
    System.out.println(g2.calculate(10, 20));

  }
}

interface CalculateSum {
  int calculate(int x, int y);
}

interface Printable {
  void print(String s);
}

interface Operation {
  int calculate();
}

interface Generic<T> {
  T calculate(T x, T y);
}
