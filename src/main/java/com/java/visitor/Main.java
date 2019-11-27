package com.java.visitor;

public class Main {
    public static void main(String[] args) {
        PersonnelVisitor visitor = new PersonnelVisitor();
        new Computer().accept(visitor);
        System.out.println(visitor.totalPrice);


    }
}
class Computer{
    ComputerPart cpu = new Cpu();
    ComputerPart bord = new Bord();
    ComputerPart memory = new Memory();
    public void accept(Visitor v){
        this.bord.accept(v);
        this.cpu.accept(v);
        this.memory.accept(v);
    }
}
abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract double getPrice();
}
class Cpu extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 1500;
    }
}
class Bord extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitBord(this);
    }

    @Override
    double getPrice() {
        return 1000;
    }
}
class Memory extends ComputerPart{

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}
interface Visitor{
    void visitCpu(Cpu cpu);
    void visitMemory(Memory memory);
    void visitBord(Bord bord);
}
class PersonnelVisitor implements Visitor{

    double totalPrice = 0.0;
    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice +=cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.8;
    }

    @Override
    public void visitBord(Bord bord) {
        totalPrice +=bord.getPrice()*0.9;
    }
}
class CorpVisitor implements Visitor{
    double totalPrice = 0.0;
    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice +=cpu.getPrice()*0.7;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.7;
    }

    @Override
    public void visitBord(Bord bord) {
        totalPrice +=bord.getPrice()*0.7;
    }
}


