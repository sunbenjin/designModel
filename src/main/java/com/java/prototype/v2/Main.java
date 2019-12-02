package com.java.prototype.v2;

import com.sun.corba.se.impl.orb.PropertyOnlyDataCollector;

/**
 * 深克隆
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        Person p2 = (Person)p.clone();
       System.out.println(p.location.name ==p2.location.name);
        p2.location.name="天津";
        System.out.println(p.location);
        System.out.println(p.location.name);
        System.out.println(p2.location.name);
        System.out.println(p2.location);
    }
}
class Location implements Cloneable{
    String name;
    String roomNo;

    public Location(String name, String roomNo) {
        this.name = name;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
class Person implements Cloneable{
    String name = "孙本进";
    int age = 32;
    Location location = new Location("北京","602");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p  = (Person)super.clone();
        p.location = (Location)location.clone();
        return p;
    }
}