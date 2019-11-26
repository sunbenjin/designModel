package com.java.observer.observer3;

import java.util.ArrayList;
import java.util.List;

/**
 * 在很多时候，观察都需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 * 事件也可以形成继承体系
 */
public class Child {
    boolean cry = false;
    List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
    public void wakeUp(){
        for(Observer o : observers){
            o.actionOnWakeUp(new WakeUpEvent(System.currentTimeMillis(),"bed",this));
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
abstract class Event<T>{
    abstract T getSource();
}
class WakeUpEvent extends Event<Child>{

    long timestamp;
    String loc;
    Child source;
    public WakeUpEvent(long timestamp,String loc,Child source){
        this.loc = loc;
        this.timestamp = timestamp;
        this.source = source;
    }
    @Override
    Child getSource() {
        return source;
    }
}
interface Observer{
    void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}
class Dad implements Observer{
    public void feed(){
        System.out.println("dad is feeding...");
    }
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        feed();
    }
}
class Mum implements Observer{

    public void hug(){
        System.out.println("mum is hugging...");
    }
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        hug();
    }
}
class Dog implements Observer{

    public void bark(){
        System.out.println("dog is barking...");
    }
    @Override
    public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
        bark();
    }
}
