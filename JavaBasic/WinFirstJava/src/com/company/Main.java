package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person V = new Person("Vadim");
        V.display();
    }
}

class Math {
    public static class Fact {
        private int result;
        private int key;

        Fact(int res, int k) {
            this.result = res;
            this.key = k;
        }

        public int getResult() {
            return this.result;
        }

        public int getKey() {
            return this.key;
        }
    }

    public static Fact valueFact(int n) {
        if(n >= 13) {
            System.out.println("VALLUE_ERROR: TOO BIG");
            return new Fact(0, n);
        }
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return new Fact(result, n);
    }
}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void display() {
        System.out.println(this.name);
    }
}

class Employee extends Person {
    private String company;

    Employee(String name, String company) {
        super(name);
        this.company = company;
    }

    @Override
    public void display() {
        System.out.printf("Name: %s\n Company: %s\n", super.getName(), this.company);
    }
}
