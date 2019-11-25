package com.java.single;

public class Single5 {
    private static Single5 instance;
    private Single5(){

    }
    public static Single5 getInstance(){
        if(instance==null){
            synchronized (Single5.class){
                if(instance==null){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Single5();
                }

            }
        }

        return instance;
    }
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Single5.getInstance().hashCode());
            }).start();
        }
    }
}
