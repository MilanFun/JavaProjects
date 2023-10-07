package OOP.Vector;

import lombok.Data;

@Data
public class Vector {
  private double x;
  private double y;

  @Override
  public String toString() {
    return "Vector{" +
      "x=" + x +
      ", y=" + y +
      ", z=" + z +
      '}';
  }

  private double z;

  public Vector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double lenOfVector() {
    return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }

  public double scalar(Vector vec) {
    return this.x * vec.getX() + this.y * vec.getY() + this.z * vec.getZ();
  }

  public Vector multiply(Vector vec) {
    return new Vector(this.y * vec.getZ() - this.z * vec.getY(),
                      this.z * vec.getX() - this.x * vec.getZ(),
                      this.x * vec.getY() - this.y * vec.getX());
  }

  public double cosAlfa(Vector vec1) {
    return this.scalar(vec1) / (vec1.lenOfVector() * this.lenOfVector());
  }

  public Vector sum(Vector vec) {
    return new Vector(this.x + vec.getX(),
                     this.y + vec.getY(),
                      this.z + vec.getZ());
  }

  public Vector subtraction(Vector vec) {
    return new Vector(this.x - vec.getX(),
                      this.y - vec.getY(),
                      this.z - vec.getZ());
  }

  public static Vector[] generate(int n) {
    Vector[] arrayOfVector = new Vector[n];
    for(int i = 0; i < n; i++) {
      arrayOfVector[i] = new Vector(Math.random(), Math.random(), Math.random());
    }
    return arrayOfVector;
  }
}
