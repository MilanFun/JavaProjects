package Basics;

public class MaxMinAvg {

    public static void main(String[] args) {
	    double[] array = new double[100];

	    for(int i = 0; i < 100; i++) {
	      array[i] = Math.random();
      }

	    double max = array[0];
	    double min = array[0];
      double avg = 0;
	    for(int j = 0; j < 100; j++) {
	      if(max < array[j]) {
	        max = array[j];
        }
	      if(min > array[j]) {
	        min = array[j];
        }
	      avg += array[j];
      }

	    avg /= 2;

	    System.out.println(max);
	    System.out.println(min);
	    System.out.println(avg);
    }
}
