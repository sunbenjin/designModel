package com.java.single;

public class Single4 {
    private static Single4 instance;
    private Single4(){

    }
    public static Single4 getInstance(){
        synchronized (Single4.class){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Single4();
        }
        return  instance;
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            new Thread(()->{
                System.out.println(Single4.getInstance().hashCode());
            }).start();
        }
    }
}
