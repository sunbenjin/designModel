package com.java.builder;

public class Main {
    public static void main(String[] args) {
        Person p = new Person.PersonBuilder()
                .basicInfo(1,"sunbenjin",12)
                .score(100)
                .weight(120.0)
                .loc("裕民东路3号","11号")
                .build();
    }
}
class Person{
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location location;
    private Person (){

    }
    public static class PersonBuilder{
        Person p = new Person();
        public PersonBuilder basicInfo(int id,String name,int age){
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }
        public PersonBuilder weight(double weight){
            p.weight = weight;
            return this;
        }
        public PersonBuilder score(int score){
            p.score = score;
            return this;
        }
        public PersonBuilder loc(String street,String roomNo){
            p.location.roomNo = roomNo;
            p.location.street = street;
            return this;

        }
        public Person build(){
            return p;
        }
    }
}
class Location {
    String street;
    String roomNo;
    public Location(String street,String roomNo){
        this.street = street;
        this.roomNo = roomNo;
    }

}