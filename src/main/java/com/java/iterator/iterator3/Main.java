package com.java.iterator.iterator3;

public class Main {
    public static void main(String[] args) {

    }
}
interface Collection_{
    void add(Object o);
    int size();
}
class ArrayList_ implements Collection_{

    Object[] objects = new Object[10];
    int index;
    @Override
    public void add(Object o) {
        if(index == objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
        }
        objects[index]=o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }
}
class LinkedList_ implements Collection_{
    Node head = null;
    Node tail = null;
    int index;
    private class Node{
        Node next;
        Object o;
        public Node(Object o){
            this.o = o;
        }
    }
    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;
        if(head==null){
            head = n;
           tail = n;
        }
        tail.next = n;
        tail = n;
        index++;

    }

    @Override
    public int size() {
        return index;
    }
}