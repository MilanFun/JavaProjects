package Basics;

import java.util.Arrays;

public class DeleteElementInArray {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 3, 4, 5, 10};

    System.out.println(Arrays.toString(deleteElement(array, 3)));
  }

  public static int[] deleteElement(int[] arr, int element) {
    int offset = 0;

    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == element) {
        offset++;
      } else {
        arr[i - offset] = arr[i];
      }
    }

    return Arrays.copyOf(arr, arr.length - offset);
  }
}
