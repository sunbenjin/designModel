package com.java.single;

import java.util.concurrent.TimeUnit;

/**
 * 懒汉式，有线程安全问题
 */
public class Single2 {

    private static Single2 instance;
    private Single2(){

    }
    public static Single2 getInstance(){
        if(instance==null){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){

            }
            instance = new Single2();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Single2.getInstance().hashCode());
            }).start();
        }
    }
}
