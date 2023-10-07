package OOP.GenerateRandomElementWithWeight;

import java.util.Arrays;

public class GenerateRandomElementWithWeight {
  private int[] array;

  public GenerateRandomElementWithWeight(int[] value, int[] weights) {
    int sum = 0;
    for(int weight : weights) {
      sum += weight;
    }

    this.array = new int[sum];
    int cursor = 0;

    for(int i = 0; i < weights.length; i++) {
      for(int j = 0; j < weights[i]; j++) {
        this.array[cursor++] = value[i];
      }
    }
  }

  public int getRandom() {
    int random = (int) (Math.random() * (this.array.length - 1));
    return this.array[random];
  }

  @Override
  public String toString() {
    return "GenerateRandomElementWithWeight{" +
      "array=" + Arrays.toString(array) +
      '}';
  }
}
