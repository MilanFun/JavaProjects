package Different;

import java.util.*;

public class UnpackedString {
  public static void main(String[] args) {
    UnpackedString check1 = new UnpackedString("2[3[xy]]z");
    System.out.println(check1.newString());
  }

  private String text;

  public UnpackedString(String text) {
    this.text = text;
  }

  public String newString() {
    StringBuilder res = new StringBuilder();
    int q = 0;
    ArrayList<Integer> mass = new ArrayList<>();
    ArrayList<Integer> mass1 = new ArrayList<>();
    String[] arrayText = this.text.split("\\[|\\]");

    for(int i = 0; i < arrayText.length; i++) {
      Scanner scanner = new Scanner(arrayText[i]);
      if(scanner.hasNextInt()) {
        mass.add(scanner.nextInt());
      } else {

        for(int f = 0; f < mass.size(); f++) {
          mass1.add(mass.get(mass.size() - 1 - f));
        }

        int count = mass1.get(q);

        for (int j = 0; j < count; j++) {
          res.append(arrayText[i]);
        }

        mass1.remove(q);
      }

    }
    System.out.println(mass1.toString());
    return res.toString();
  }
}



