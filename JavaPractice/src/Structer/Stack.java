package Structer;

import java.util.Arrays;

public class Stack {
  public static void main(String[] args) {
    Stack stack = new Stack(5);
    System.out.println(stack.isEmpty());
    for(int i = 0; i < 5; i++) {
      stack.push(i);
    }
    stack.print();
    System.out.println(stack.isEmpty());
    System.out.println(stack.isFull());
    System.out.println(stack.readTop());
    stack.pop();
    stack.print();
    System.out.println(stack.readTop());
    System.out.println(stack.isFull());
  }

  private int size;
  private int[] array;
  private int top;

  public Stack(int size) {
    array = new int[size];
    this.size = size;
    this.top = -1;
  }

  public void push(int data) {
    this.array[++top] = data;
  }

  public void pop() {
    this.array = Arrays.copyOf(this.array, this.array.length - 1);
    this.top--;
    this.size--;
  }

  public int getSize() {
    return this.size;
  }

  public void print() {
    for(int i = this.top; i > -1; i--) {
      System.out.print(this.array[i] + " ");
    }
  }

  public int readTop() {
    if(!this.isEmpty()) {
      return this.array[this.top];
    }
    return -1;
  }

  public boolean isEmpty() {
    if(this.size == 0 || this.top == -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if(this.size == (this.top + 1)) {
      return true;
    } else {
      return false;
    }
  }
}
