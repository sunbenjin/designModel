package com.java.state.v1;

public class Main {
    public static void main(String[] args) {
        MM mm = new MM();
        mm.say();
    }
}
abstract class MMSate{
    abstract void smile();
    abstract void cry();
    abstract void say();
}
class MMHappyState extends MMSate{

    @Override
    void smile() {
        System.out.println("happy smile...");
    }

    @Override
    void cry() {
        System.out.println("happy cry...");
    }

    @Override
    void say() {
        System.out.println("happy say...");
    }
}
class MMSadState extends MMSate{

    @Override
    void smile() {
        System.out.println("sad smile...");
    }

    @Override
    void cry() {
        System.out.println("sad cry...");
    }

    @Override
    void say() {
        System.out.println("sad say...");
    }
}
class MM{
    MMSate state = new MMHappyState();
    public void smile(){
        state.smile();
    }
    public void cry(){
        state.cry();
    }
    public void say(){
        state.say();
    }
}

