package com.java.factory.abstractfactory;

public class Main {

    public static void main(String[] args) {
        AbstractFactory af = new ModenFactory();
        //AbstractFactory af = new MagicFactory();
        Food food = af.foodCreate();
        food.printName();
        Vehicle vehicle = af.vehicleCreate();
        vehicle.go();
        Weapon weapon = af.weaponCreate();
        weapon.shot();
    }
}
