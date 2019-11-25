package com.java.factory.abstractfactory;

public class MagicFactory extends AbstractFactory{
    @Override
   public Food foodCreate() {
        return new MarshRoom();
    }

    @Override
    public Vehicle vehicleCreate() {
        return new Broom();
    }

    @Override
    public  Weapon weaponCreate() {
        return new MagicStick();
    }
}
