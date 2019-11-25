package com.java.single;

public class Single3 {
    private static Single3 instance;
    private Single3(){

    }
    public static synchronized Single3 getInstance(){
        if(instance==null){
            instance = new Single3();
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}
