package com.java.single;

public enum Single7 {
    Instance;

    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Single7.Instance.hashCode());
            }).start();
        }
    }
}
