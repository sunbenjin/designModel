package com.java.observer.observer1;

import java.util.ArrayList;
import java.util.List;

public class Child {
        private  boolean cry = false;
        private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
        public boolean isCry(){
            return cry;
        }
        public void wakeUp(){
            cry = true;
            for(Observer o: observers){
                o.actionOnWakeup();
            }
        }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }

}
interface Observer{
    void actionOnWakeup();
}
class Dad implements Observer{

    public void feed(){
        System.out.println("dad is feeding...");
    }
    @Override
    public void actionOnWakeup() {
        feed();
    }
}
class  Mum implements Observer{
    public void hug(){
        System.out.println("mum is hugging...");
    }
    @Override
    public void actionOnWakeup() {
         hug();
    }
}
class Dog implements Observer{
    public void bark(){
        System.out.println("dog is barking..");
    }
    @Override
    public void actionOnWakeup() {
               bark();
    }
}
