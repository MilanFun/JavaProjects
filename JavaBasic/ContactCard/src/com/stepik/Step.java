package com.stepik;

import java.math.BigInteger;
import java.util.Arrays;

public class Step {
    public static void main(String... args) {
        System.out.println(factorial(5));
        int[] a = {4, 10};
        int[] b = {11, 2, 3};
        int[] c = new int[5];
        c = mergeArrays(a, b);
        for(int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static boolean isPollindrom(String text) {
        String tmp = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuffer buf = new StringBuffer(tmp);
        String equality = buf.reverse().toString();
        if(tmp.equals(equality)) {
            return true;
        } else {
            return false;
        }
    }

    public static BigInteger factorial(int value) {
        if(value == 0) {
            return BigInteger.valueOf(1);
        } else {
            BigInteger n = BigInteger.valueOf(1);
            for (int i = 1; i <= value; i++) {
                n = n.multiply(BigInteger.valueOf(i));
            }
            return n;
        }
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int len = a1.length + a2.length;
        int[] arr = new int[len];
        int count = 0;

        for(int i = 0; i < a1.length; i++) {
            arr[i] = a1[i];
            count++;
        }
        for(int j = 0; j < a2.length; j++) {
            arr[count++] = a2[j];
        }

        Arrays.sort(arr);
        return arr;
    }
}
