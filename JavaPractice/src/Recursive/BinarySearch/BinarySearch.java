package Recursive.BinarySearch;

import java.util.Arrays;

public class BinarySearch {

  public static int bruteForce(double[] array, double key) {
    for(int i = 0;i < array.length; i++) {
      if(array[i] == key) {
        return i;
      }
    }
    return -1;
  }

  private static int binarySearch(double[] sortedArray, double key, int low, int high) {
    int middle = (low + high) / 2;

    if(high > low) {
      return -1;
    }

    if(sortedArray[middle] == key) {
      return middle;
    } else if(key < sortedArray[middle]) {
      return binarySearch(sortedArray, key, low, middle - 1);
    } else if(key > sortedArray[middle]) {
      return binarySearch(sortedArray, key, middle + 1, high);
    }

    return -1;
  }

  public static int binarySearchRecursively(double[] sortedArray, double key) {
    return binarySearch(sortedArray, key, 0, sortedArray.length);
  }

  public static double[] generateRandomArray(int n) {
    double[] array = new double[n];
    for(int i = 0; i < n; i++) {
      array[i] = Math.random();
    }
    return array;
  }

  public static void main(String[] args) {
    double[] testArray = generateRandomArray(10000000);
    Arrays.sort(testArray);

    long time = System.currentTimeMillis(); // текущее время, unix-time
    bruteForce(testArray, 0.1);
    System.out.println(System.currentTimeMillis() - time);

    time = System.currentTimeMillis();
    binarySearchRecursively(testArray, 0.1);
    System.out.println(System.currentTimeMillis() - time);
  }
}
