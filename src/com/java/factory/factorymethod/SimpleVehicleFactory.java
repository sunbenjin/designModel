package com.java.factory.factorymethod;

public class SimpleVehicleFactory {

    public Car carCreator(){
        System.out.println("a car created...");
        return new Car();
    }

    public Plane planeCreator(){
        System.out.println("a plane created....");
        return new Plane();
    }
}
