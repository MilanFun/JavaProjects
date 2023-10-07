package Basics;

public class BubbleSort {
  public static void main(String[] args) {
    double[] array = new double[100];

    for(int i = 0; i < 100; i++) {
      array[i] = Math.random();
    }

    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array.length - i - 1; j++) {
        if(array[j] > array[j + 1]) {
          double temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }

    for(int k = 0; k < array.length; k++) {
      System.out.println(array[k]);
    }

  }
}
