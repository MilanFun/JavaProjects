package OOP.GenerateRandomElementWithWeight;

public class Main {
  public static void main(String[] args) {
    int[] values = new int[3];
    int[] weights = new int[3];

    values[0] = 1;
    values[1] = 2;
    values[2] = 3;

    weights[0] = 1;
    weights[1] = 3;
    weights[2] = 10;

    GenerateRandomElementWithWeight gen = new GenerateRandomElementWithWeight(values, weights);
    System.out.println(gen.toString());
    System.out.println(gen.getRandom());
  }
}
