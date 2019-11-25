package com.java.factory.abstractfactory;

public class ModenFactory extends AbstractFactory{
    @Override
    public Food foodCreate() {
        return new Bread();
    }

    @Override
    public Vehicle vehicleCreate() {
        return new Car();
    }

    @Override
    public  Weapon weaponCreate() {
        return new AK47();
    }
}
