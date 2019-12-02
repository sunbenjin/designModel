package com.java.prototype.v1;

/**
 * 浅克隆
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        Person p2 = (Person)p.clone();
        System.out.println(p2.loc.name==p.loc.name);
        p2.loc.name="bj";
        System.out.println(p.loc.name);

    }
}
class Location{
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
}
class Person implements Cloneable{

    String name="sunbenjin";
    int age = 10;
    Location loc=new Location("tj","602");
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

