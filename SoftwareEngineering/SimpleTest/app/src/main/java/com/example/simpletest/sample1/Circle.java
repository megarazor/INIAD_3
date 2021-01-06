package com.example.simpletest.sample1;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color){
        this.radius= radius;
        this.color= color;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getRadius(){
        return radius;
    }

    public String getColor(){
        return color;
    }
}
