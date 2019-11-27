package com.java.iterator.iterator2;

public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for(int i=0; i<10; i++){
            list.add(new String("s"+i));
        }
        System.out.println(list.size);
    }
}
class LinkedList_{
    Node head=null;
    Node tail=null;
    int size;
    public void add(Object o){

        Node n  = new Node(o);
        n.next=null;
        if(head == null){
            head = n;
            tail = n;
        }
        tail.next=n;
        tail = n;
        size++;
    }
    private class Node{
        private Object o;
        Node next;
        public Node (Object o){
            this.o = o;
        }
    }
    public int size(){
        return size;
    }
}

