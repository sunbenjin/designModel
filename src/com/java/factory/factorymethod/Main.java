package com.java.factory.factorymethod;

public class Main {
    public static void main(String[] args) {

        Moveable m = new CarFactory().creator();
        m.go();
    }
}
