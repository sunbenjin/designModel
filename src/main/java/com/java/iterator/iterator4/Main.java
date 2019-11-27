package com.java.iterator.iterator4;

public class Main {
    public static void main(String[] args) {
        ArrayList_ lists = new ArrayList_();
        for(int i=0; i<10; i++){
            lists.add(new String("s"+i));
        }
        Iterator_ iterator_ = lists.iterator();
        while (iterator_.hasNext()){
            System.out.println(iterator_.next());
        }
    }
}
interface Collection_{
    void add(Object o);
    int size();
    Iterator_ iterator();
}
interface Iterator_{
    boolean hasNext();
    Object next();
}
class ArrayList_ implements Collection_{

    Object[] objects = new Object[10];
    int index = 0;
    @Override
    public void add(Object o) {
        if(index==objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index ++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator_{

        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if(currentIndex>=index)return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}
class LinkedList_ implements Collection_{

    Node head = null;
    Node tail = null;
    int size = 0;
    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next =null;
        if(head ==null){
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator_ iterator() {
        return null;
    }
    private class Node{
        private Object o;
        Node next;
        public Node(Object o){
            this.o = o;
        }
    }
}
