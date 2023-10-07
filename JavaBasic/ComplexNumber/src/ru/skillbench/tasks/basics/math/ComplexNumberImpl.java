package ru.skillbench.tasks.basics.math;
import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {
    private double re = 0.0;
    private double im = 0.0;

    public static void main(String[] args) {

    }

    @Override
    public double getRe() {
        return this.re;
    }

    @Override
    public double getIm() {
        return this.im;
    }

    @Override
    public boolean isReal() {
        if(this.im == 0) {
            return (true);
        } else {
            return (false);
        }
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        value = value.replaceAll(" ","");
        if(value.contains(String.valueOf("+")) || (value.contains(String.valueOf("-"))
                && value.lastIndexOf('-') > 0)) {
            value = value.replaceAll("i","");
            value = value.replaceAll("I","");
            if(value.indexOf('+') > 0) {
                this.re = Double.parseDouble(value.substring(0, value.indexOf('+')));
                this.im = Double.parseDouble(value.substring(value.indexOf('+') + 1, value.length()));
            } else if (value.lastIndexOf('-') > 0) {
                this.re = Double.parseDouble(value.substring(0,value.lastIndexOf('-')));
                this.im = Double.parseDouble(value.substring(value.lastIndexOf('-') + 1, value.length()));
            }
        } else {
            if(value.endsWith("i") || value.endsWith("I")) {
                value = value.replaceAll("i","");
                value = value.replaceAll("I","");
                this.re = 0;
                this.im = Double.parseDouble(value);
            } else {
                value = value.replaceAll("i","");
                value = value.replaceAll("I","");
                this.im = 0;
                this.re = Double.parseDouble(value);
            }
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber other = new ComplexNumberImpl();
        other.set(this.getRe(), this.getIm());
        return other;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber)(super.clone());
    }

    @Override
    public String toString() {
        if (re == 0.0) {
            if (im == 0.0) {
                return "0";
            } else {
                return String.format("%fi", im);
            }
        } else if (im == 0.0) {
            return String.format("%f", re);
        } else {
            return String.format("%f%fi", re, im);
        }
    }

    @Override
    public boolean equals(Object other) {
        if((this) == (ComplexNumber)other) {
            return (true);
        } else {
            return (false);
        }
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double squareAbsoluteDifference = this.getRe()*this.getRe() + this.getIm() * this.getIm() -
                other.getRe()*other.getRe() + other.getIm() * other.getIm();
        return (int)(squareAbsoluteDifference);
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.set(-1.0*this.getRe(), -1.0*this.getIm());
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.set(arg2.getRe() + this.getRe(), arg2.getIm() + this.getIm());
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        this.set(arg2.getRe() * this.getRe() - arg2.getIm() * this.getIm(),
                this.getIm() * arg2.getRe() + this.getRe() * arg2.getIm());
        return this;
    }
}

