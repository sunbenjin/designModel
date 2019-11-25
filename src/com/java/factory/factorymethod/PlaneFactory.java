package com.java.factory.factorymethod;

public class PlaneFactory {
    public Plane creator(){
        System.out.println("a plane created....");
        return new Plane();
    }
}
