package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    private double[] arr;
    private int length = 0;

    public static void main(String[] args) {

    }

    @Override
    public void set(double...elements) {
        this.arr = new double[elements.length];
        for(int i = 0; i  < elements.length; i++) {
            this.arr[i] = elements[i];
        }
    }

    @Override
    public double[] get() {
        return this.arr;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector array = new ArrayVectorImpl();
        array.set(this.arr.clone());
        return array;
    }

    @Override
    public int getSize() {
        return this.length;
    }

    @Override
    public void set(int index, double value) {
        if(index >= this.length) {
            this.arr = Arrays.copyOf(this.arr, index + 1);
            this.length += index;
        }
        if(index >= 0) {
            this.arr[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return this.arr[index];
    }

    @Override
    public double getMin() {
        double min = this.arr[0];
        for(int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] < min) {
                min = this.arr[i];
            }
        }
        return min;
    }

    @Override
    public double getMax() {
        double max = this.arr[0];
        for(int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] > max) {
                max = this.arr[i];
            }
        }
        return max;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(this.arr);
    }

    @Override
    public void mult(double factor) {
        for(int i = 0; i < this.arr.length; i++) {
            this.arr[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int minlenght = 0;
        if(this.length > anotherVector.getSize()) {
            minlenght = anotherVector.getSize();
        } else {
            minlenght = this.length;
        }

        for(int i = 0; i < minlenght; i++) {
            this.arr[i] += anotherVector.get(i);
        }

        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int minlenght = Math.min(this.length, anotherVector.getSize());
        double res = 0.0;

        for(int i = 0; i < minlenght; i++) {
            this.arr[i] *= anotherVector.get(i);
            res += this.arr[i];
        }

        return res;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}
