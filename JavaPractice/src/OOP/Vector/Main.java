package OOP.Vector;


public class Main {
  public static void main(String[] args) {
    Vector[] vectors = Vector.generate(10);
    System.out.println(vectors[0].toString());
    System.out.println(vectors[1].toString());
    System.out.println(vectors[0].lenOfVector());
    System.out.println(vectors[0].scalar(vectors[1]));
    System.out.println((vectors[0].multiply(vectors[1]).toString()));
    System.out.println(vectors[0].cosAlfa(vectors[1]));
    System.out.println(vectors[0].sum(vectors[1]));
    System.out.println(vectors[0].subtraction(vectors[1]));

    for(int i = 0; i < 10; i++) {
      System.out.println(vectors[i].toString());
    }
  }
}
