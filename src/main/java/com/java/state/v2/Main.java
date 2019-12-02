package com.java.state.v2;

public class Main {
}
abstract class CarState{
    abstract void open();
    abstract void closed();
    abstract void running();
    abstract void stopped();
}
class OpenTheDoor extends CarState {

    @Override
    void open() {

    }

    @Override
    void closed() {

    }

    @Override
    void running() {

    }

    @Override
    void stopped() {

    }
}
class CloseTheDoor extends CarState{

    @Override
    void open() {

    }

    @Override
    void closed() {

    }

    @Override
    void running() {

    }

    @Override
    void stopped() {

    }
}
class RunTheCar extends CarState{

    @Override
    void open() {

    }

    @Override
    void closed() {

    }

    @Override
    void running() {

    }

    @Override
    void stopped() {

    }
}
class StopTheCar extends CarState{

    @Override
    void open() {

    }

    @Override
    void closed() {

    }

    @Override
    void running() {

    }

    @Override
    void stopped() {

    }
}
class Car {
    CarState state = new OpenTheDoor();
    public void running(){
        state.running();
    }
    public void stop(){
        state.stopped();
    }
    public  void close(){
        state.closed();
    }
    public void open (){
        state.open();
    }
}