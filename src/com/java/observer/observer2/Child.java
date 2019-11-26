package com.java.observer.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 在很多时候，观察者需要根据事件的具体情况进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 */
public class  Child{
    private boolean cry = false;
    List<Observer> observers = new ArrayList<>();
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
        WakeUpEvent wakeUpEvent = new WakeUpEvent(System.currentTimeMillis(),"ben",this);
        for(Observer o : observers){
           o.actionOnWakeUpEvent(wakeUpEvent);
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
class WakeUpEvent {
    long timestamp;
    String loc;
    Child source;
    public WakeUpEvent(long timestamp,String loc,Child source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}
interface Observer{
    void actionOnWakeUpEvent(WakeUpEvent wakeUpEvent);
}
class Dad implements Observer{

    public void feed(){
        System.out.println("dad is feeding...");
    }
    @Override
    public void actionOnWakeUpEvent(WakeUpEvent wakeUpEvent) {
        feed();
    }
}
class  Mum implements Observer{

    public void hug(){
        System.out.println("mum is hugging...");
    }
    @Override
    public void actionOnWakeUpEvent(WakeUpEvent wakeUpEvent) {
        hug();
    }
}
class Dog implements Observer{

    public void bark(){
        System.out.println("dog is barking...");
    }
    @Override
    public void actionOnWakeUpEvent(WakeUpEvent wakeUpEvent) {
        bark();
    }
}
