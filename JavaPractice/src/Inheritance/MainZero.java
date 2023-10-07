package Inheritance;

import java.util.ArrayList;

public class MainZero {

  public static void main(String[] args) {
    Ball ball = new Ball(4.5);
    Cylinder cylyinder = new Cylinder(2, 2);
    Pyramid pyramid = new Pyramid(100, 100);

    Box box = new Box(1000);

    System.out.println(box.add(ball)); // ok
    System.out.println(box.add(cylyinder)); // ok
    System.out.println(box.add(pyramid)); // failed
  }
}

class ShapeVerZero {
  protected double volume;

  public ShapeVerZero(double volume) {
    this.volume = volume;
  }

  public double getVolume() {
    return this.volume;
  }
}

class SolidOfRevolution extends ShapeVerZero {

  protected double radius;

  public SolidOfRevolution(double volume, double radius) {
    super(volume);
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }
}

class Ball extends SolidOfRevolution {
  public Ball(double radius) {
    super(Math.PI * Math.pow(radius, 3) * 4 / 3, radius);
  }
}

class Cylinder extends SolidOfRevolution {
  private double heightC;

  public Cylinder(double radius, double height) {
    super(Math.PI * Math.pow(radius, 2) * height, radius);
    this.heightC = height;
  }
}

class Pyramid extends ShapeVerZero {
  private double heightP;
  private double ss;

  public Pyramid(double height, double s) {
    super(height * s * 4 / 3);
    this.heightP = height;
    this.ss = ss;
  }
}

class Box extends ShapeVerZero {
  private ArrayList<? super ShapeVerZero> shapes = new ArrayList<>();
  private double available;

  public Box(double available) {
    super(available);
    this.available = available;
  }

  public boolean add(ShapeVerZero shape) {
    if(this.available > shape.getVolume()) {
      shapes.add(shape);
      available -= shape.getVolume();
      return true;
    } else {
      return false;
    }
  }
}
