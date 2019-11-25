package com.java.factory.factorymethod;

public class CarFactory {
    public Car creator(){
        System.out.println("a car created....");
        return new Car();
    }
}
