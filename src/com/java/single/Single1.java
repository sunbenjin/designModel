package com.java.single;

/**
 * 饿汉式
 */
public class Single1 {

    private static final Single1 instance = new Single1();
    private Single1(){

    }
    public static Single1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Single1.getInstance().hashCode());
            }).start();
        }
    }
}
